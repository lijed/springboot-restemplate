/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.learn.springbootrestemplate.resttemplate;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/11/17
 **/
public class CustomizeErrorHandler extends DefaultResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {

        if (getResponseBodyLength(response) == 0) {
            return true;
        }
        return super.hasError(response);
    }

    private int getResponseBodyLength(ClientHttpResponse response) throws IOException {

//        InputStream inputStream = response.getBody();
//        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//        StringBuilder sb = new StringBuilder();
//        String line = br.readLine();
//        while (StringUtils.hasLength(line)) {
//            sb.append(line);
//            line = br.readLine();
//        }
//        br.close();
//        return sb.toString().length();
        return  1;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (getResponseBodyLength(response) == 0) {
            throw new RuntimeException("Not found");
        }
        super.handleError(response);
    }
}
