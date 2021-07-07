package com.kkb.util;


import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ResultVO
 *  返回结果的统一封装类
 * @author wanglina
 * @version 1.0
 */

public class ResultVO<T> {
    private PageInfo<T> pageInfo;//返回的是分页对象
    private List<T> list;//返回的是集合
    private Map<T,List<T>> map;
    private T obj;//返回的是单个对象
    private Integer code=200;//表示返回的状态码
    private String msg="ok";//表示可以展示给用户的信息

    public ResultVO(Map<T, List<T>> map) {
        this.map = map;
    }

    public Map<T, List<T>> getMap() {
        return map;
    }

    public void setMap(Map<T, List<T>> map) {
        this.map = map;
    }

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public ResultVO(List<T> list) {
        this.list = list;
    }

    public ResultVO(T obj) {
        this.obj = obj;
    }

    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

