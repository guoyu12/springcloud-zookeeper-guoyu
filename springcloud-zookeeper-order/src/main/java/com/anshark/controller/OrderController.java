package com.anshark.controller;

import com.alibaba.fastjson.JSONObject;
import com.anshark.feign.MemberFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author GUOYU
 * @Date 2021/1/19
 * @Desc
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MemberFeign memberFeign;

    @Value("${data.info}")
    private String configVal;

    @RequestMapping("/test1")
    public String test1() {
        return JSONObject.toJSONString(discoveryClient.getServices());
    }

    @RequestMapping("/test2")
    public String test2() {
        return JSONObject.toJSONString(discoveryClient.getInstances("myzkserver"));
    }

    @RequestMapping("/test3")
    public String test3() {
        String url = "http://myzkmember/member/getMember";
        String forObject = restTemplate.getForObject(url, String.class);
        return "订单查询会员 -> " + forObject;
    }

    /**
     * feign客户端
     * @return
     */
    @RequestMapping("/test4")
    public String test4() {
        return "feign -> " + memberFeign.getMember();
    }

    String hello() {
        return "网络正忙请稍后重试!!!";
    }

    /**
     * hystrix熔断器
     * @return
     */
    @HystrixCommand(fallbackMethod = "hello")
    @RequestMapping("/test5")
    public String test5() {
        return "feign -> " + memberFeign.getMember();
    }

    /**
     * 测试配置中心数据
     * @return
     */
    @RequestMapping("/test6")
    public String test6() {
        return configVal;
    }

}
