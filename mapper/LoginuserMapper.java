package com.kkb.mapper;

import com.kkb.pojo.Loginuser;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginuserMapper {


    Loginuser selectByPrimaryKey(String u_loginName);

}