/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.learn.springbootrestemplate.controller;

import com.me.learn.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/11/16
 **/

@RestController
public class TestController {

    //默认的restTemplate
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("httpClientRestRemplate")
    RestTemplate restTemplate;


    @GetMapping("/user/{userName}")
    public User getUser(@PathVariable String userName) {
        String uri = "http://localhost:8085/user/{userName}";

        Map<String, String> map = new HashMap();
        map.put("userName", userName);

        User user = restTemplate.getForObject(uri, User.class, map);
        System.out.println(user);
        return user;
    }


    /**
     *  上传多个文件
     *
     MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
     body.add("files", new FileSystemResource(filePath1));
     body.add("files", new FileSystemResource(filePath2));
     body.add("files", new FileSystemResource(filePath3));
     */
    @GetMapping("/uploadFile")
    public void uploadFile() {
        String uri = "http://localhost:8085/user/upload";
        MultiValueMap<String, Object> multiPartBody = new LinkedMultiValueMap<>();
//        multiPartBody.add("file", new ClassPathResource("tmp/user.txt"));
        multiPartBody.add("file", new FileSystemResource("D:\\wp_review\\ws-spring-boot\\springboot-restemplate\\src\\main\\resources\\tmp\\user.txt"));
        RequestEntity<MultiValueMap<String, Object>> body = RequestEntity
                .post(uri)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(multiPartBody);

        restTemplate.exchange(body, Void.class);
    }

    @GetMapping("/downloadFile")
    public void download() {
        String uri = "";
        RequestEntity requestEntity = RequestEntity.get(uri).build();
        ResponseEntity<byte[]> responseEntity = restTemplate.exchange(requestEntity, byte[].class);
        byte[] downloadContent = responseEntity.getBody();

// 大文件
        ResponseExtractor<ResponseEntity<File>> responseExtractor = new ResponseExtractor<ResponseEntity<File>>() {

            @Override
            public ResponseEntity<File> extractData(ClientHttpResponse response) throws IOException {
                File rcvFile = File.createTempFile("rcvFile", "zip");
                FileCopyUtils.copy(response.getBody(), new FileOutputStream(rcvFile));
                return ResponseEntity.status(response.getStatusCode()).headers(response.getHeaders()).body(rcvFile);
            }
        };
        ResponseEntity<File> responseEntity1 = this.restTemplate.execute(uri, HttpMethod.GET, null, responseExtractor);

    }

    /**
     * 下载打文件 大文件
     */
    @GetMapping("/downloadBigFile")
    public void downloadBigFile() {
        String uri = "";
        ResponseExtractor<ResponseEntity<File>> responseExtractor = new ResponseExtractor<ResponseEntity<File>>() {
            @Override
            public ResponseEntity<File> extractData(ClientHttpResponse response) throws IOException {
                File rcvFile = File.createTempFile("rcvFile", "zip");
                FileCopyUtils.copy(response.getBody(), new FileOutputStream(rcvFile));
                return ResponseEntity.status(response.getStatusCode()).headers(response.getHeaders()).body(rcvFile);
            }
        };
        ResponseEntity<File> responseEntity1 = this.restTemplate.execute(uri, HttpMethod.GET, null, responseExtractor);
    }
}
