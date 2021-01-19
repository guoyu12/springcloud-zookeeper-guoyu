package com.anshark.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author GUOYU
 * @Date 2021/1/19
 * @Desc
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/getMember")
    public String getMember() {
        return "会员服务 -> " + port;
    }


}
