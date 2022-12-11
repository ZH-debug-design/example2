package com.ZH.community;

import com.ZH.community.dao.UserMapper;
import com.ZH.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest

public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;



    @Test
    public void selectTest(){
        User user=userMapper.selectById(101);
        System.out.println(user);
    }
    @Test
    public void insertTest(){
        User user=new User();
        user.setUsername("zhaohao");
        user.setPassword("123456");
        user.setSalt("123");
        user.setEmail("p1007zh@163.com");
        user.setType(2);
        user.setStatus(1);
        user.setActivationCode("123456");
        user.setHeaderUrl("www.newcoder.com/101.png");
        user.setCreateTime(new Date());
        int rows=userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }
    @Test
    public void updateTest(){
        int rows=userMapper.updateStatus(0,154);
        System.out.println(rows);
        System.out.println(userMapper.selectById(154).getStatus());
    }




}
