package com.kkb.controller;

import com.github.pagehelper.PageInfo;
import com.kkb.pojo.Hosregister;
import com.kkb.service.HosregisterService;
import com.kkb.util.HosregisterQueryVO;
import com.kkb.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: Aaron
 * @Description:
 * @Date Created in 2021-06-06 20:48
 * @Modified By:
 */

@Controller
@RequestMapping("hosregister")
@ResponseBody
public class HosregisterController {
    @Autowired
    private HosregisterService hosregisterService;

    @InitBinder
    protected void initDateFormatBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    //多条件分页查询
    @RequestMapping(value = "list.do")
    public ResultVO<Hosregister> queryByPage(Integer pageNumber, Integer pageSize, HosregisterQueryVO vo){
        if(pageNumber==null || pageNumber<=0){
            pageNumber=1;
        }
        if(pageSize==null || pageSize<=0){
            pageSize=5;
        }
        System.out.println("条件查询:"+vo);
        PageInfo<Hosregister> hosregisterPageInfo = hosregisterService.queryByPage(pageNumber, pageSize, vo);
        System.out.println("controller:  "+hosregisterPageInfo.getList().get(0));
        System.out.println("controller:  "+hosregisterPageInfo.getList().get(0).getDoctor());
        System.out.println(hosregisterPageInfo.getList());
        return new ResultVO<>(hosregisterPageInfo);
    }

    //根据主键查询
    @RequestMapping(value = "listByKey.do")
    public ResultVO<Hosregister> queryById(HttpServletRequest request){
       // String s = request.getParameter("hosR_id");
        String ss = request.getParameter("editHosR_id");
        Integer hosR_id = 1;
        if(ss!= null){
            hosR_id = Integer.parseInt(ss);
        }else{
            String s = request.getParameter("hosR_id");
            hosR_id = Integer.parseInt(s);
        }

        Hosregister hosregister = hosregisterService.queryByID(hosR_id);
        return new ResultVO<>(hosregister);
    }
    //查询所有科室以及对应的所有医生姓名
    @RequestMapping(value = "listKeshi.do")
    public ResultVO<String> queryAllKeshi(HttpServletRequest request){
        Map<String, List<String>> map = hosregisterService.queryAllKeshi();
        for(String key : map.keySet()){
            List<String> list = map.get(key);
        }

        return new ResultVO<String>(map);
    }
    //添加一个挂号信息
    @RequestMapping(value = "addHosregister.do",method = RequestMethod.POST)
    public ResultVO<Hosregister> addTeam(String selectDoctor, String selectKeshi, Hosregister hosregister){
        int i = hosregisterService.addHosregister(selectDoctor,selectKeshi,hosregister);
        if(i==1){
            return new ResultVO<Hosregister>();
        }
        return new ResultVO<>(500,"服务器内部异常，请稍后再试！");
    }

    //更新挂号信息
    @RequestMapping(value = "updateHosregister.do",method = RequestMethod.PUT)
    public ResultVO<Hosregister> updateHosregister(String selectDoctor, String selectKeshi, Hosregister hosregister){
        int i = hosregisterService.updateHosregister(selectDoctor,selectKeshi,hosregister);
        if(i==1){
            return new ResultVO<Hosregister>();
        }
        return new ResultVO<>(500,"服务器内部异常，请稍后再试！");
    }



    //根据主键删除
    @RequestMapping(value ="deleteHosregister.do",method = RequestMethod.DELETE)
    public ResultVO<Hosregister> deleteTeam(HttpServletRequest request){
        String hosR_id = request.getParameter("hosR_id");
        if(hosR_id != null){
            int id = Integer.parseInt(hosR_id);
            int i = hosregisterService.deleteById(id);
            if(i==1){
                return new ResultVO<Hosregister>();
            }
        }
        return new ResultVO<>(500,"服务器内部异常，请稍后再试！");
    }

}
