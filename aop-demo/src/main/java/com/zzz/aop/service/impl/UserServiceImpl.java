package com.zzz.aop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzz.aop.bean.User;
import com.zzz.aop.mapper.UserMapper;
import com.zzz.aop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author zjc
 * @Date 2023/2/17 11:09
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
