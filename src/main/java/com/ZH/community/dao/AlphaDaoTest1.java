package com.ZH.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author zh
 * @Email p1007zh@163.com
 * @Data 2022/11/19 19:35
 * @Description
 */
@Repository
@Primary
public class AlphaDaoTest1 implements AlphaDao{


    @Override
    public String select() {
        return  "2";
    }

    public void select1() {
        System.out.println("3");
    }

    public void select2() {
        System.out.println("4");
    }


}
