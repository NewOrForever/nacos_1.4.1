package com.example.stock.service;

import org.springframework.stereotype.Service;

/**
 * ClassName:StockService
 * Package:com.example.stock.service
 * Description:
 *
 * @Date:2022/6/22 11:00
 * @Author:qs@1.com
 */
@Service
public class StockService {
    public String deductStock(Integer productId, Integer stockCount) {
        System.out.println("商品productId=" + productId + "：扣减库存" + stockCount);
        return "success";
    }
}
