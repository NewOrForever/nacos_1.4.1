package com.example.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:TestController
 * Package:com.example.stock.controller
 * Description: 测试@Value的值动态更新
 *
 * @Date:2022/6/30 9:42
 * @Author:qs@1.com
 */
@RequestMapping("/test")
@RestController
@RefreshScope // bean重走一便生命周期应该是
public class TestController {

    @Value("${test.value:aaa}")
    private String testVal;

    @RequestMapping("/testvalue")
    public void testValue() {
        System.out.println("==============> " + testVal);
    }
}
