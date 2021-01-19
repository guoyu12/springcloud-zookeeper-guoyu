package com.anshark.ribbon;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author GUOYU
 * @Date 2021/1/19
 * @Desc
 */
@Component
public class RibbonConfig {

    /**
     * @return
     * @LoadBalanced 开启负载均衡的能力
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
