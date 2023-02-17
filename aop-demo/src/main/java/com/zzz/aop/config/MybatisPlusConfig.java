package com.zzz.aop.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zjc
 * @Date 2023/2/17 10:51
 */

@Configuration
@MapperScan(basePackages = "com.zzz.aop.mapper")
public class MybatisPlusConfig {
    
}
