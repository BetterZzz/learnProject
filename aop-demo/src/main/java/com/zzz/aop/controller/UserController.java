package com.zzz.aop.controller;

import com.zzz.aop.bean.User;
import com.zzz.aop.common.LogAnnotation;
import com.zzz.aop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zjc
 * @Date 2023/2/17 11:11
 */

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("list")
    @LogAnnotation(module = "用户", operator = "获取用户列表")
    public List<User> list() {
        return userService.list();
    }

}
