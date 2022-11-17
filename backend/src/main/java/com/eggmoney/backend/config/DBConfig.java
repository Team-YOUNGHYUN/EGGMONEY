package com.eggmoney.backend.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.eggmoney.backend.model.dao")
public class DBConfig {

}
