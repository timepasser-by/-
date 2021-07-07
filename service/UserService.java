package com.kkb.service;

import com.kkb.mapper.LoginuserMapper;
import com.kkb.pojo.Loginuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: Aaron
 * @Description:
 * @Date Created in 2021-06-04 20:54
 * @Modified By:
 */
@Service
public class UserService {
    @Autowired
    LoginuserMapper loginUserMapper;

    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public int login(Loginuser user){
        Loginuser loginUser = loginUserMapper.selectByPrimaryKey(user.getU_loginName());

        //用户名或密码错误，返回1
        if(loginUser == null || !loginUser.getU_passWord().equals(user.getU_passWord())){
            return 1;
        }
        System.out.println(loginUser.getU_state());
        //被禁用登录返回2
        if(loginUser.getU_state() == 1){
            return 2;
        }
        //登录成功返回0
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("loginUser",loginUser);
         return 0;
    }
}
