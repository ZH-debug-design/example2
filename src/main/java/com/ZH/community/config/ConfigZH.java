package com.ZH.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @author zh
 * @Email p1007zh@163.com
 * @Data 2022/11/19 21:26
 * @Description
 */
@Configuration
public class ConfigZH {
    @Bean
    public SimpleDateFormat dateFormatZH(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
