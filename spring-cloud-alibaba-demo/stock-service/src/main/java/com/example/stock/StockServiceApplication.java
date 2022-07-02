package com.example.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class StockServiceApplication {


    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(StockServiceApplication.class, args);
        for (;  ; ) {
            String name = applicationContext.getEnvironment().getProperty("user.name");
            String age = applicationContext.getEnvironment().getProperty("user.age");
            String env = applicationContext.getEnvironment().getProperty("cur.env");
            System.out.println("cur env is -> " + env + ", user name is -> " + name + ", age is -> " + age);
            TimeUnit.SECONDS.sleep(3);
        }

    }

}
