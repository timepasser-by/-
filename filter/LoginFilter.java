package com.kkb.filter;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;


/**
 * @Author: Aaron
 * @Description:
 * @Date Created in 2021-06-05 17:16
 * @Modified By:
 */
@Resource
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强制转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //获取资源请求路径
        String uri = request.getRequestURI();

        //判断是否包含登录相关资源路径,要注意排除掉css,js,验证码等资源
//        if (uri.contains("login.html") || uri.contains("login") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts") || uri.contains("/image/") || uri.contains("/checkCode")) {
//            //包含放行
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//
//            //不包含,跳转登陆页面
//            //从session中获取user
//            Object user = request.getSession().getAttribute("loginUser");
//            if (user != null) {
//                //登录了放行
//                filterChain.doFilter(servletRequest, servletResponse);
//            } else {
//                //没有登陆，跳转登陆页面
//                JOptionPane.showMessageDialog(null, "此用户未登录！");
//                response.sendRedirect("login.html");
//            }
//        }
        filterChain.doFilter(servletRequest, servletResponse);

    }
}