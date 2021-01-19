package com.anshark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author GUOYU
 * @Date 2021/1/19
 * @Desc 配置中心服务端
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigZkApp {


    public static void main(String[] args) {

        SpringApplication.run(ConfigZkApp.class, args);

    }

}
