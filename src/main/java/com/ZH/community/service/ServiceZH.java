package com.ZH.community.service;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zh
 * @Email p1007zh@163.com
 * @Data 2022/11/19 20:20
 * @Description
 */
@Service
@Scope("prototype")
public class ServiceZH {
    public ServiceZH() {
        System.out.println("1");
    }

    @PostConstruct
    public void select() {
        System.out.println("2");
    }

    @PostConstruct
    public void select1() {
        System.out.println("3");
    }

    @PreDestroy
    public void select2() {
        System.out.println("4");
    }

}
