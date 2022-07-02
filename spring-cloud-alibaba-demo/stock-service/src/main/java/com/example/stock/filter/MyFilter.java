package com.example.stock.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:MyFilter
 * Package:com.example.stock.filter
 * Description: 测试过滤器
 *
 * @Date:2022/6/29 13:48
 * @Author:qs@1.com
 */
@Component
public class MyFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("==============> myfilter");
        filterChain.doFilter(request, response);
    }
}
