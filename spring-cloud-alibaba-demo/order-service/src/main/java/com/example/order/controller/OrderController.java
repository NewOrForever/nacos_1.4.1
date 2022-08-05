package com.example.order.controller;

import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/create/{productId}/{stockCount}")
    public String create(@PathVariable Integer productId, @PathVariable Integer stockCount) {
        return orderService.create(productId, stockCount);
    }

    @RequestMapping("/findOrderByUserId/{id}")
    public String findOrderByUserId(@PathVariable Integer id) {
        System.out.println("==========>集群限流保护测试");

        // 模拟异常测试熔断降级
        if (id == 5) {
            throw new IllegalArgumentException("非法参数异常");
        }

        return String.format("拿到了%s的订单信息", id.toString());
    }

    @RequestMapping("/testRibbon")
    public void testRibbon() {
        restTemplate.getForObject("http://stock-service/test/ribbon", Void.class);
    }



    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
