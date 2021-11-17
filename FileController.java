package com.example.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.example.demo.Mapper.GoodMapper;
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
    public String   upload(MultipartFile file) throws IOException {
    String Filename = file.getOriginalFilename();
    //定义文件的唯一标识
    String flag = IdUtil.fastSimpleUUID();
    String url = System.getProperty("user.dir")+"/src/main/resources/file/" + flag + "_" + Filename;
    goodMapper.updateurl(url);
    FileUtil.writeBytes(file.getBytes(),url);
    return url;
}


}
