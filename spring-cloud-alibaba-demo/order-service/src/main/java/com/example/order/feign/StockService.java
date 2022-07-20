package com.example.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:StockService
 * Package:com.example.order.feign
 * Description: feign核心就是拼接url -> 交给ribbon
 *
 * @Date:2022/6/22 12:55
 * @Author:qs@1.com
 */
@FeignClient(name = "stock-service", path = "/stock")
public interface StockService {
    @RequestMapping("/deduct/{productId}/{stockCount}")
    String deductStock(@PathVariable Integer productId, @PathVariable Integer stockCount);
}
