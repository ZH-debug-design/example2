package com.ZH.community;

import com.ZH.community.dao.DiscussPostMapper;
import com.ZH.community.entity.DiscussPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
/**
 * @author zh
 * @Email p1007zh@163.com
 * @Data 2022/11/28 10:47
 * @Description
 */
public class DiscussPostTest {

    @Autowired
    private DiscussPostMapper discussPostMapper;


    @Test
    public  void  selectDiscussPosts(){
        List<DiscussPost> list=discussPostMapper.selectDiscussPosts(133,0,10);
        for(DiscussPost d:list){
            System.out.println(d);
        }
    }

    @Test
    public  void  selectDiscussPostRows(){
        int rows=discussPostMapper.selectDiscussPostRows(133);
        System.out.println(rows);
    }

}

