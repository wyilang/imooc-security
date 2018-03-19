package com.imooc.web.controller;

import com.imooc.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.stream.IntStream;

/**
 * @program: imooc-security
 * @description:简单的关于SpringMVC的上传与下载
 * @author: Neo.Wang
 * @create: 2018-03-11 20:08
 **/
@RestController
@RequestMapping("/file")
public class FileController {
    String folder = "/Users/neo/Projects/imooc-security/imooc-security-demo/src/main/java/com/imooc/web/file";
    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        File localFile = new File(folder,new Date().getTime() + ".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //jdk1.7的新特性，写在try里的io代码块不需要显式的去catch-finally里去关闭流，Java会自动关闭
        try(InputStream intStream = new FileInputStream(new File(folder,id + ".txt"));
            OutputStream outputStream = response.getOutputStream();){
            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition","attachment:filename=test.txt");
            IOUtils.copy(intStream,outputStream);
            outputStream.flush();
        }
    }
}
