package com.example.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order/user")
public class UserController {
    @RequestMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> map = new HashMap<>();
        Map<String, List<User>> pageMap = new HashMap<>();
        map.put("page", pageMap);

        List<User> list = new ArrayList<>();
        pageMap.put("list", list);
        list.add(new User(1, "a", 18));
        list.add(new User(2, "b", 19));

        return map;
    }

    class User {
        private Integer id;
        private String username;
        private Integer age;

        public User(Integer id, String username, Integer age) {
            this.id = id;
            this.username = username;
            this.age = age;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
