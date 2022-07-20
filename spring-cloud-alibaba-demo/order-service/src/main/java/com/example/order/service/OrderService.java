package com.example.order.service;

import com.example.order.feign.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:OrderService
 * Package:com.example.order.service
 * Description:
 *
 * @Date:2022/6/22 12:55
 * @Author:qs@1.com
 */
@Service
public class OrderService {

    // FeignClientFactoryBean
    @Autowired
    private StockService stockService;

    public String create(Integer productId, Integer stockCount) {
        System.out.println("创建订单成功");  // TODO
        System.out.println(stockService.deductStock(productId, stockCount));

        return "success";
    }
}
