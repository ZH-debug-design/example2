package com.ZH.community.controller;

import com.ZH.community.dao.DiscussPostMapper;
import com.ZH.community.dao.UserMapper;
import com.ZH.community.entity.DiscussPost;
import com.ZH.community.entity.Page;
import com.ZH.community.entity.User;
import com.ZH.community.service.DiscussPostService;
import com.ZH.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zh
 * @Email p1007zh@163.com
 * @Data 2022/11/28 16:27
 * @Description
 */
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscussPostService discussPostService;

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String indexDiscussPosts(Model model, Page page){
        //因为dispatcherServlet会自动将page加载到model中，所以不用往model中添加page
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        List<DiscussPost> list = discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
        List<Map<String,Object>> discussPosts=new ArrayList<>();
        if(list!=null){
            for(DiscussPost p:list){
                Map<String,Object> map=new HashMap<>();
                map.put("post",p);
                User user=userService.findUserById(p.getUserId());
                map.put("user",user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussPosts);
        return "/index";
    }
}
