package com.ZH.community.service;

import com.ZH.community.dao.UserMapper;
import com.ZH.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zh
 * @Email p1007zh@163.com
 * @Data 2022/11/28 15:36
 * @Description
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User findUserById(int userId){
        return userMapper.selectById(userId);
    }
}
