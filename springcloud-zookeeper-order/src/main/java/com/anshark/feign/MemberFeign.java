package com.anshark.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author GUOYU
 * @Date 2021/1/19
 * @Desc
 */
@FeignClient(name = "myzkmember")
public interface MemberFeign {

    @RequestMapping("/member/getMember")
    String getMember();
}
