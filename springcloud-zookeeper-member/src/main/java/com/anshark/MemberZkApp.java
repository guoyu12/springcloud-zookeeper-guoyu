package com.anshark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author GUOYU
 * @Date 2021/1/19
 * @Desc
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RequestMapping("/app")
public class MemberZkApp {

    public static void main(String[] args) {

        SpringApplication.run(MemberZkApp.class, args);

    }

    @RequestMapping("/hello")
    String hello() {
        return "member hello";
    }

}
