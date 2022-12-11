package com.ZH.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @author zh
 * @Email p1007zh@163.com
 * @Data 2022/11/19 17:24
 * @Description
 */
@Repository("abcd")
public class AlphaDaoTest implements AlphaDao {


    @Override
    public String select() {
        return  "吃";
    }
}
