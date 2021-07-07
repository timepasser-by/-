package com.kkb.controller;


import com.kkb.pojo.Loginuser;
import com.kkb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import javax.xml.stream.Location;
import java.awt.*;
import java.io.IOException;

/**
 * @Author: Aaron
 * @Description:
 * @Date Created in 2021-06-04 20:52
 * @Modified By:
 */

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/judge.do")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       String verify = request.getParameter("verify");
       //验证码不能为空
       if(verify == null || "".equals(verify)){
           JOptionPane.showMessageDialog(null, "验证码不能为空！");
           response.sendRedirect("/login.html");
       }
       //用户名或密码不能为空
       else if(username == null || "".equals(username)||password == null || "".equals(password)){
           JOptionPane.showMessageDialog(null, "用户名或密码不能为空！");
           response.sendRedirect("/login.html");
       }else{
           Loginuser user = new Loginuser();
           user.setU_loginName(username);
           user.setU_passWord(password);
           int judge = userService.login(user);
           //验证码错误
           if(!verify.equals( "7236")){
               JOptionPane.showMessageDialog(null, "验证码输入错误！");
               response.sendRedirect("/login.html");
           }
          //用户名或密码错误
           else if(judge == 1){
               JOptionPane.showMessageDialog(null, "用户名或密码错误！");
               response.sendRedirect("/login.html");
           }
           //被禁用登录
           else if(judge == 2){
               JOptionPane.showMessageDialog(null, "此用户被禁用，请联系管理员！");
               response.sendRedirect("/login.html");
           }
           //登录成功
           else {
               System.out.println("欢迎进入！");
               JOptionPane.showMessageDialog(null, "欢迎进入！");
               response.sendRedirect("/index.html");
           }
       }
    }
}
