package com.ZH.community.dao;

import com.ZH.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zh
 * @Email p1007zh@163.com
 * @Data 2022/11/27 22:21
 * @Description
 */
@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //如果是动态sql语句并且有if判断，则需要添加@Param注解
    int selectDiscussPostRows(@Param("userId") int userId);

}
