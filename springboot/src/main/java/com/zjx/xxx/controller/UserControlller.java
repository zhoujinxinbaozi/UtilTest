package com.zjx.xxx.controller;

import com.zjx.xxx.Entity;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// http://localhost:8080/springboot/gerUserByGet?userName=zhoujinxin&userAge=12
@RestController //直接以json的形式进行返回
@SpringBootApplication
@RequestMapping(value = "/springboot")
public class UserControlller {
    @RequestMapping(value = "/gerUserByGet", method = RequestMethod.GET)
    public Entity getUserByGet(@RequestParam(value = "userName") String userName, @RequestParam(value = "userAge") int userAge){
        Entity entity = new Entity(userName, userAge);
        java.util.HashSet list = new HashSet<String>();
        list.add("123");
        return entity;
    }
}
