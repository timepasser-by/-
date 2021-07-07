package com.kkb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkb.mapper.DoctorMapper;
import com.kkb.mapper.HosregisterMapper;
import com.kkb.pojo.Doctor;
import com.kkb.pojo.DoctorExample;
import com.kkb.pojo.Hosregister;
import com.kkb.pojo.HosregisterExample;
import com.kkb.util.HosregisterQueryVO;
import com.kkb.util.ResultVO;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.print.Doc;
import java.util.*;


/**
 * @Author: Aaron
 * @Description:
 * @Date Created in 2021-06-06 20:49
 * @Modified By:
 */
@Service
public class HosregisterService {
    @Autowired
    private HosregisterMapper hosregisterMapper;
    @Autowired
    private DoctorMapper doctorMapper;
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public PageInfo<Hosregister> queryByPage(Integer pageNum, Integer pageSize, HosregisterQueryVO vo) {
//多条件
        DoctorExample doctorExample = new DoctorExample();
        DoctorExample.Criteria doctorExampleCriteria = doctorExample.createCriteria();
        String dName = null;
        String dKeshi = null;
        if(vo!=null) {

            if (vo.getD_name() != null && !"".equals(vo.getD_name().trim())) {
                dName = vo.getD_name();
            }
            if (vo.getD_keshi() != null && !"".equals(vo.getD_keshi().trim())) {
                dKeshi = vo.getD_keshi();
            }

        }
        //分页
        Doctor doctor = null;
        if(dName!=null ||dKeshi != null){
            doctor = doctorMapper.selectByDnameAndDKeshi(dName,dKeshi);
        }
        HosregisterExample example=new HosregisterExample();
        //创建条件的容器
        HosregisterExample.Criteria criteria = example.createCriteria();
        if(vo!=null){
            if(vo.getHosR_id()!=null&&vo.getHosR_id() != 0){
                criteria.andHosR_idEqualTo(vo.getHosR_id());
            }
            if(vo.getHosR_dateStart()!=null){
                criteria.andHosR_dateGreaterThanOrEqualTo(vo.getHosR_dateStart());
            }
            if(vo.getGetHosR_dateEnd()!=null){
                criteria.andHosR_dateLessThanOrEqualTo(vo.getGetHosR_dateEnd());
            }
            if(doctor!=null){
                criteria.andD_idEqualTo(doctor.getD_id());
            }
        }
        //分页
        PageHelper.startPage(pageNum,pageSize);
        List<Hosregister> list = hosregisterMapper.selectByExample(example);
        for(Hosregister hosregister : list){
            Doctor doctorss = doctorMapper.selectByPrimaryKey(hosregister.getD_id());
            hosregister.setDoctor(doctorss);
        }
        System.out.println("查找:    "+list.get(0));
        System.out.println("查找:    "+list.get(0).getDoctor());
        return new PageInfo<>(list);
    }
    //根据主键查询
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public Hosregister queryByID(Integer hosR_id) {
        DoctorExample doctorExample = new DoctorExample();
        HosregisterExample example=new HosregisterExample();
        //创建条件的容器
        Hosregister hosregister = null;
        if(hosR_id !=null && hosR_id != 0) {
                hosregister = hosregisterMapper.selectByPrimaryKey(hosR_id);
                    Doctor doctor = doctorMapper.selectByPrimaryKey(hosregister.getD_id());
                    hosregister.setDoctor(doctor);
                }
        return hosregister;
    }
    //查询所有科室以及对应的所有医生姓名
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public Map<String,List<String>> queryAllKeshi() {
        DoctorExample doctorExample = new DoctorExample();
        List<Doctor> doctors = doctorMapper.selectByExample(doctorExample);
        //key对应科室 value对应医生姓名
        Map<String,List<String>> hashMap = new HashMap<>();
       for(Doctor doctor : doctors){
           String name = doctor.getD_name();
           String keshi = doctor.getD_keshi();
           hashMap.putIfAbsent(keshi,new LinkedList<>());
           hashMap.get(keshi).add(name);
       }
       return hashMap;
    }
    //添加挂号信息
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public int addHosregister(String d_name, String d_keshi,Hosregister hosregister){
//        DoctorExample doctorExample = new DoctorExample();
//        DoctorExample.Criteria doctorExampleCriteria = doctorExample.createCriteria();
//        if (d_name != null && !"".equals(d_name.trim())) {
//            doctorExampleCriteria.andD_nameEqualTo("%" + d_name.trim() + "%");
//        }
//        if (d_keshi != null && !"".equals(d_keshi.trim())) {
//            doctorExampleCriteria.andD_keshiEqualTo("%" + d_keshi.trim() + "%");
//        }
        //分页
        String dName = d_name;
        String dKeshi = d_keshi;
        Doctor doctor = doctorMapper.selectByDnameAndDKeshi(dName,dKeshi);
        int d_id = doctor.getD_id();
        hosregister.setD_id(d_id);
        Date date = new Date();
        hosregister.setHosR_date(date);
        hosregister.setHosR_state(0);
        return hosregisterMapper.insertSelective(hosregister);
    }



    //更新挂号信息
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public int updateHosregister(String d_name, String d_keshi,Hosregister hosregister){
        String dName = d_name;
        String dKeshi = d_keshi;
        Doctor doctor = doctorMapper.selectByDnameAndDKeshi(dName,dKeshi);
        int d_id = doctor.getD_id();
        hosregister.setD_id(d_id);
        Hosregister hosregister1 = hosregisterMapper.selectByPrimaryKey(hosregister.getHosR_id());
        hosregister.setHosR_state(hosregister1.getHosR_state());
        hosregister.setHosR_date(hosregister1.getHosR_date());
        HosregisterExample hosregisterExample = new HosregisterExample();
       int i =  hosregisterMapper.updateByExample(hosregister,hosregisterExample);
        return i;
        //!!!!!!!!!!!!
    }



    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public int deleteById(int id){
        return hosregisterMapper.deleteByPrimaryKey(id);

    }
}
