package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.provider.api.OrdersService;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "付款日修改审核相关操作")
@RestController
@RequestMapping(value = "ordersPay")
public class OrdersPayController {
    @Reference(version = "1.0.0")
    private OrdersService ordersService;
}
