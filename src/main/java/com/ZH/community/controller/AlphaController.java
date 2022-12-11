package com.ZH.community.controller;

import com.ZH.community.dao.AlphaDaoTest;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    //依赖注入
    @Autowired
    private AlphaDaoTest a;

    //get的一个例子
    @RequestMapping("/hello")
    @ResponseBody
    public  String hello(){
        return "Hello";
    }
//        public  void hello(){
//        System.out.println("??");
//    }

    //调用方法
    @RequestMapping("/select")
    @ResponseBody
    public  String select(){
        return a.select();
    }

    //底层请求数据和响应数据的内容
    @RequestMapping("/RequestAndResponse")
    public void  RR(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 请求数据内容
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()){
            String name=headers.nextElement();
            String value=request.getHeader(name);
            System.out.println(name+": "+value);
        }
        System.out.println(request.getParameter("code"));

        // 响应数据内容
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer=response.getWriter();
        writer.write("<h1>吃屁</h1>");
        writer.close();

    }

    //Get请求数据的一种写法 /student？current=.&limit=
    @RequestMapping(path ="/student",method = RequestMethod.GET)
    @ResponseBody
    public  String student(
        @RequestParam(name="current", required = false , defaultValue = "10") int current,
        @RequestParam(name="limit",required = false,defaultValue = "1") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "students";
    }

    //Get请求数据的另一种写法 /student/123
    @RequestMapping(path = "/student1/{id}",method = RequestMethod.GET)
    @ResponseBody
    public  String student1(
            @PathVariable("id") int id
    ){
        System.out.println(id);
        return "student";
    }

    //Post命令发送数据
    @RequestMapping(path = "/student2",method = RequestMethod.POST)
    @ResponseBody
    public String student2(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return  "success";
    }

    //响应HTML数据
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView teacher(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("name","教师");
        mav.addObject("age","27");
        mav.setViewName("/demo/view");
        return mav;

    }

    //响应HTML数据.方式二
    @RequestMapping(path = "/teacher2",method = RequestMethod.GET)
    public String teacher1(Model model){
        model.addAttribute("name","教师");
        model.addAttribute("age","18");
        return "/demo/view";
    }

    //响应JSON数据
    //Java -> JSON ->JS
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> teacher2(){
        Map<String,String> map=new HashMap<>();
        map.put("name","家铭");
        map.put("age","26");
        map.put("height","180cm");
        return map;
    }

    //响应JSON数据.响应集合数据
    //Java -> JSON ->JS
    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,String>> teacher3(){
        List<Map<String,String>> list=new ArrayList<>();
        Map<String,String> map=new HashMap<>();
        map.put("name","家铭");
        map.put("age","26");
        map.put("height","180cm");
        list.add(map);

        map=new HashMap<>();
        map.put("name","青岭");
        map.put("age","25");
        map.put("height","170cm");
        list.add(map);

        map=new HashMap<>();
        map.put("name","赵豪");
        map.put("age","24");
        map.put("height","175cm");
        list.add(map);

        return list;
    }




}
