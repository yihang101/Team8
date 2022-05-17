package com.example.demo.config;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Data
@Component
@ConfigurationProperties(prefix = "alipay")
public class AliPayConfig {
    private String appId;
    private String appPrivateKey;
    private String alipayPublicKey;
    private String notifyUrl;


    @PostConstruct
    public void init() {
        // 设置参数（全局只需设置一次）
        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = "openapi.alipaydev.com";
        config.signType = "RSA2";
        config.appId = "2021000119694158";
        config.merchantPrivateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCc2k+cYoQn8rN7ysd1GU9zwyYLYxjotb5KV8tYNqGYQ6ccuGtexvPUu1iY5SS3E8leI88/ag0TC0ylz9piOhIvlmI7jXwa4MUhNEeZpyjmMCKS6+0Ejyc4EPc7ix/ecM+O0bGFapodUZstyoS+lwir/MMv1D9XXB0hH5iuut+yaLuWVIy3KnysQEgNHhpVA/TeJM8MtqIxOj416q3sQOWJj6CGDUYxgROXH7UUfpd63fyYuZzukhVJTyprGLBDAk1ufzCS+DJdlLeDoCL9N4d+XmQbk0N90bKjo7HM3Ew0My6hD74GecYoRVIIcAM0WNU2iBxP5gy2/bLCRlInVGHZAgMBAAECggEAQN3r9JGtc9PkNDrNN/kqqYY4Epd98qdOtfIO70FQnObFkpQWG1EN/5km77w77dap/Vuz1tbl501R+nS2LM81PCbmIxjFDVyNSckUH1BJEsEvWzFkiPEm2AH0LNTBbj2bKMZBsxo9+AgKs+o/8Y4GkRHsKriNJXS7uzoU65Xu8xnFR/8/1sNJd7cy/RYbuxojbAT20yvsjjNuzUTnF8eMM+cTBgN8D9UumRPXQ0bccfsNhg16XILQ6Ands4rQNjGfYG3hsBMlkeBcxavmt0BL6sTYx+iVOqNRqAnpbvnM4QJsSM00VgHiLsg1kjM0oTXsjzleb07GXLbHdka+v3VgzQKBgQDNQmfF9Vk1CBk6gkWgEcI7Uq1wTDwZwTCHOlQOGrCBxZvZcBDm3EoAHfN7hKDRwhOMAF1rEJR+L1PZryBBzfUEBVxCh775FnIp5OblXDDA/nJjJNMHHMLdy0ROW3kt//YnpdTF6V8x3YQh/dvbcvkGrGR70lBoziNTr5i6u2EvxwKBgQDDoI0CsqMxfdq6HhInOc2Widjz2NTVguaPDNuBq/cP2QqUZpkSWXaaIngFeB6IcPZ/gi6lGgsG9LPhw+jBHUINl5ieec2O9RLUcRE/8ROXXcT15WfYE2lCZktoKEIgXAKkZag0WtF9FAiQRvJbOqh0M7Hx2Oax3YbOSuenBg0hXwKBgDE+bD0e9q71aXATDvcvK4Ul+bxGXejj42ud/8p+drg7m39YFoX8dbh/dwm8MQUB5cSh1ce465c2bYx9KmT/L3gufQrtHFEQJIWOiCKgsoWqxfCpRgOfz9R8Tr/pzDHQBdNPQrPUoGULOwcYq2WDuODz/QuD0ozCX9FVAHRUPiXDAoGAVvPj+ZEBbJwuPo/jLcBJm2IGJsz4PTcD2A20+7w+ArNMOo4n97oAN56ejn/HwonDZwWsSgJ7aEoYMn9r03p3w6bgVYB6V9Ki3f6r1ioHtT4er9WaBLcMEFF7rv5F9jAvlHcC/tJnTxs6ezatvtMh0RSxQXhRgjmfE87DjL/p0i0CgYATop4KvIK91iXePjnhT7lai54SZWj3LoST2XxKttO0aCsQIpxM836kM/RX0+Bsrf/kiTX8SQjooO9BWsnp3bwn3muR9RLIWGOP7ODKxQwFReCe9j5lF8CatTNy44bzSsajxR2Q13xvq6ewsQS2IUwl874kmVFP4n9jctJ4kSzKxA==";
        config.alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmj+CoapF+6I5Cx5W1xaW8beDJ10zAlfLhL0CjSSliY/aig/miDgB2Is5aovH07rqeWGgjC64EGqkYAK559e2SPWv/HJ7pMeVsSfVpac01vmTYVDfWrlsDLxD91JejIARJY0VitrqDQ/zGkZ+SA9wUdcwR/L/XITzR0ZUpWW4mLvbHQEglLzrtGPTQiWXl0ytJEGVBsB9BLte0Rp7IBbVI07DqZ+ljKcUhovyt7gJWeuW5kuLARZRGo6anorIY+jiFDUP5YLv3BsxwPbqk2240WnbSn0ld1lSJATAtUwhyyadX4/FHyfw0O0cEAOUwJKQYc45g5+R+bOHu9sWnr0/EQIDAQAB";
        config.notifyUrl = "http://ips5nn.natappfree.cc/alipay/notify";
        Factory.setOptions(config);
        System.out.println("=======支付宝SDK初始化成功=======");
    }

}

