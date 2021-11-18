package com.me.learn.springbootrestemplate;

import com.me.learn.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootRestemplateApplication {




    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestemplateApplication.class, args);

    }


}
