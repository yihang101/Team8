package com.example.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.example.demo.Mapper.GoodMapper;
import com.example.demo.entiy.Good;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
@Configuration
public class FileController  implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:C:/work/pdf/");
    }
    @Resource
    GoodMapper goodMapper;
    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        String str = "";
        Good good1 = null;
        good1 = goodMapper.getall2();
        System.out.println(good1);
            String Filename = file.getOriginalFilename();
            //定义文件的唯一标识
            String flag = IdUtil.fastSimpleUUID();
            String url = "C:/work/pdf/" + flag + "_" + Filename;
            str="http://47.113.204.132:8081/upload/"+flag + "_" + Filename;
            Good good = new Good();
            good.setUrl(str);
            goodMapper.save2(good);
            FileUtil.writeBytes(file.getBytes(),url);

        return str;

    }
    /*@PostMapping("/upload")
  /**  @ApiOperation("文件上传")**/
   /* public String uploadImg(MultipartFile file){
        if (file.isEmpty()) {
            System.out.println("上传的文件为空！");
        }
        // 文件名
        String fileName = file.getOriginalFilename();
        // 获取文件后缀名
        String extension = fileName.substring(fileName.indexOf("."));
        // 上传文件的路径
        String uploadFolder = "/tmp/nft/uploads/";
        // 生成一个新的文件名
        String flag = IdUtil.fastSimpleUUID();
        fileName =  flag + extension;
        File dest = new File(uploadFolder + fileName);
        // 检测文件目录是否存在 不存在则创建
    /*    if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CheckException("文件上传失败");
        }
        // 返回虚拟文件访问路径
        return "/upload/" + fileName;
    }*/

}


