package com.ZH.community.dao;

import com.ZH.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

import javax.jws.soap.SOAPBinding;

/**
 * @author zh
 * @Email p1007zh@163.com
 * @Data 2022/11/25 22:03
 * @Description
 */
@Mapper
public interface UserMapper{
    User selectById(int id);

    User selectByName(String username);

    int insertUser(User user);

    int updateStatus(int status,int id);

}
