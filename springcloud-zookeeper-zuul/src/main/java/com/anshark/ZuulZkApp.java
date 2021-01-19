package com.anshark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

/**
 * @Author GUOYU
 * @Date 2021/1/19
 * @Desc
 */
@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class ZuulZkApp {

    public static void main(String[] args) {

        SpringApplication.run(ZuulZkApp.class, args);

    }

    /**
     * zuul配置能够使用config实现实时更新
     * @return
     */
    @RefreshScope
    @ConfigurationProperties
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }

}
