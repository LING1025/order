package com.funtl.myshop.plus.business.feign;

import com.funtl.myshop.plus.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "business-user",path = "user",configuration = FeignRequestConfiguration.class)
public interface UserFeign {
    /**
     * 获取个人信息
     * @param username
     * @return
     */
//    @GetMapping(value = "info/{username}")
//    String info(@PathVariable String username);

    /**
     * 获取微信个人信息
     * @param openId
     * @return
     */
    @GetMapping(value = "wxInfo/{openId}")
    String wxInfo(@PathVariable String openId);
}
