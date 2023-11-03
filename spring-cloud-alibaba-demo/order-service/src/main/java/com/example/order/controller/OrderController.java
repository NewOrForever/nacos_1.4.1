package com.example.order.controller;

import com.example.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/create/{productId}/{stockCount}")
    public String create(@PathVariable Integer productId, @PathVariable Integer stockCount) {
        return orderService.create(productId, stockCount);
    }

    @RequestMapping("/testRibbon")
    public void testRibbon() {
        restTemplate.getForObject("http://stock-service/test/ribbon", Void.class);
    }

    @RequestMapping("/testGateWay")
    public String testGateWay() {
        return "welcome to gateway";
    }
    @RequestMapping("/testGateWayAddRequestHeader")
    public String testGateWayAddRequestHeaderFilter(@RequestHeader("X-Request-color") String color) {
        log.info("[AddRequestHeaderGatewayFilterFactory test]===========>X-Request-color请求头的值为：{}", color);
        return "success";
    }
        @RequestMapping("/testGateWayAddRequestParameter")
    public String testGateWayAddRequestParameterFilter(@RequestParam String myParam) {
        log.info("[AddRequestParameterGatewayFilterFactory test]===========>myParam请求参数的值为：{}", myParam);
        return "success";
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
