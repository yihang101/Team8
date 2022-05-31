package com.example.demo.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.example.demo.config.AliPayConfig;
import com.example.demo.entiy.Order;
import com.example.demo.mapper.OrderMapper;
/*import com.example.demo.common.Result;
import com.example.springboot.config.AliPayConfig;*/
import com.example.demo.controller.dto.AliPay;
/*import com.example.springboot.entity.Orders;
import com.example.springboot.mapper.OrdersMapper;*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/alipay")
public class AliPayController {

    private static final String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";
    private static final String FORMAT = "JSON";
    private static final String CHARSET = "UTF-8";
    //签名方式
    private static final String SIGN_TYPE = "RSA2";

    @Resource
    private AliPayConfig aliPayConfig;

    @Resource
    private OrderMapper ordersMapper;

    @GetMapping("/pay") // &subject=xxx&traceNo=xxx&totalAmount=xxx
    public void pay(AliPay aliPay, HttpServletResponse httpResponse) throws Exception {

        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, aliPayConfig.getAppId(),
                aliPayConfig.getAppPrivateKey(), FORMAT, CHARSET, aliPayConfig.getAlipayPublicKey(), SIGN_TYPE);


        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();  // 发送请求的 Request类
        request.setNotifyUrl(aliPayConfig.getNotifyUrl());
        JSONObject bizContent = new JSONObject();
        bizContent.set("out_trade_no", aliPay.getTraceNo());  // 我们自己生成的订单编号
        bizContent.set("total_amount", aliPay.getTotalAmount()); // 订单的总金额
        bizContent.set("subject", aliPay.getSubject());   // 支付的名称
        bizContent.set("product_code", "FAST_INSTANT_TRADE_PAY");  // 固定配置
        request.setBizContent(bizContent.toString());


        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @PostMapping("/notify")  // 注意这里必须是POST接口
    public String payNotify(HttpServletRequest request) throws Exception {
        if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
            System.out.println("=========支付宝异步回调========");

            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (String name : requestParams.keySet()) {
                params.put(name, request.getParameter(name));

            }

            String tradeNo = params.get("out_trade_no");
            String gmtPayment = params.get("gmt_payment");
            String alipayTradeNo = params.get("trade_no");

            String sign = params.get("sign");
            String content = AlipaySignature.getSignCheckContentV1(params);
            boolean checkSignature = AlipaySignature.rsa256CheckContent(content, sign, aliPayConfig.getAlipayPublicKey(), "UTF-8"); // 验证签名

            if (checkSignature) {

                System.out.println("交易名称: " + params.get("subject"));
                System.out.println("交易状态: " + params.get("trade_status"));
                System.out.println("支付宝交易凭证号: " + params.get("trade_no"));
                System.out.println("商户订单号: " + params.get("out_trade_no"));
                System.out.println("交易金额: " + params.get("total_amount"));
                System.out.println("买家在支付宝唯一id: " + params.get("buyer_id"));
                System.out.println("买家付款时间: " + params.get("gmt_payment"));
                System.out.println("买家付款金额: " + params.get("buyer_pay_amount"));


                ordersMapper.finishPay(tradeNo,gmtPayment,alipayTradeNo);
            }
        }
        return "success";
    }

    @GetMapping("/return")
    public Boolean returnPay(AliPay aliPay) throws AlipayApiException {
        // 7天无理由退款
        String now = DateUtil.now();
        Order orders = ordersMapper.getByNo(aliPay.getTraceNo());
        if (orders != null) {

            long between = DateUtil.between(DateUtil.parseDateTime(orders.getPaymenttime()), DateUtil.parseDateTime(now), DateUnit.DAY);
            if (between > 7) {
                return false;
            }
        }



        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL,
                aliPayConfig.getAppId(), aliPayConfig.getAppPrivateKey(), FORMAT, CHARSET,
                aliPayConfig.getAlipayPublicKey(), SIGN_TYPE);

        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.set("trade_no", aliPay.getAlipayTraceNo());  // 支付宝回调的订单流水号
        bizContent.set("refund_amount", aliPay.getTotalAmount());  // 订单的总金额
        bizContent.set("out_request_no", aliPay.getTraceNo());   //  我的订单编号

        request.setBizContent(bizContent.toString());

        AlipayTradeRefundResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            System.out.println("退款成功");

            ordersMapper.updatePayState(aliPay.getTraceNo());
            return true;
        } else {
            System.out.println(response.getBody());
            return false;
        }

    }
}

