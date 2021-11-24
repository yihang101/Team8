package com.example.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.example.demo.Mapper.GoodMapper;
import com.example.demo.entiy.Good;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;


@RestController
@RequestMapping("/file")
public class FileController {
    @Resource
    GoodMapper goodMapper;
@PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {

    String str = "";
    Good good1 = null;
    good1 = goodMapper.getall2();
    System.out.println(good1);
    if(good1==null){
        String Filename = file.getOriginalFilename();
        System.out.println(Filename);
        //定义文件的唯一标识
        String flag = IdUtil.fastSimpleUUID();
        String url = System.getProperty("user.dir")+"/src/main/resources/static/" + flag + "_" + Filename;
        str="http://localhost:8081/"+flag + "_" + Filename;
        System.out.println(str);
        Good good = new Good();
        good.setUrl(str);
        System.out.println(good);
        goodMapper.save2(good);
        FileUtil.writeBytes(file.getBytes(),url);
    }else{
        str="1";//已有商品
    }
    return str;

}


}
