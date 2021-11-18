/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.learn.springbootrestemplate.config;

import com.me.learn.springbootrestemplate.resttemplate.CustomizeErrorHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/11/17
 **/
@Configuration
public class RestTemplateConfig {

    @Bean("defaultRestTemplate")
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        restTemplate.setErrorHandler(new CustomizeErrorHandler());
        return restTemplate;
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory(CloseableHttpClient httpClient) {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setHttpClient(httpClient);
        return clientHttpRequestFactory;
    }

    @Bean("httpClientRestRemplate")
    public RestTemplate httpClientRestTemplate(RestTemplateBuilder builder, HttpComponentsClientHttpRequestFactory clientHttpRequestFactory) {
        RestTemplate restTemplate = builder.build();
        restTemplate.setErrorHandler(new CustomizeErrorHandler());
        restTemplate.setRequestFactory(clientHttpRequestFactory);
        return restTemplate;
    }
}
