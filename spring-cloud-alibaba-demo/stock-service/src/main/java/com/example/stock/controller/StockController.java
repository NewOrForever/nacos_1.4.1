package com.example.stock.controller;

import com.example.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:StockController
 * Package:com.example.stock.controller
 * Description:
 *
 * @Date:2022/6/22 11:00
 * @Author:qs@1.com
 */
@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @RequestMapping("/deduct/{productId}/{stockCount}")
    public String deduct(@PathVariable Integer productId, @PathVariable Integer stockCount) {
        return stockService.deductStock(productId, stockCount);
    }
}
