package com.example.order.controller;

import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:OrderController
 * Package:com.example.order.controller
 * Description:
 *
 * @Date:2022/6/22 11:25
 * @Author:qs@1.com
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/create/{productId}/{stockCount}")
    public String create(@PathVariable Integer productId, @PathVariable Integer stockCount) {
        return orderService.create(productId, stockCount);
    }
}
