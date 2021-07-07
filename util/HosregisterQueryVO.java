package com.kkb.util;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: Aaron
 * @Description:
 * @Date Created in 2021-06-06 20:52
 * @Modified By:
 */

public class HosregisterQueryVO {
    private Integer hosR_id;
    private String d_name;
    private String d_keshi;
    private  Date hosR_dateStart;
    private Date getHosR_dateEnd;

    @Override
    public String toString() {
        return "HosregisterQueryVO{" +
                "hosR_id=" + hosR_id +
                ", d_name='" + d_name + '\'' +
                ", d_keshi='" + d_keshi + '\'' +
                ", hosR_dateStart=" + hosR_dateStart +
                ", getHosR_dateEnd=" + getHosR_dateEnd +
                '}';
    }

    public Integer getHosR_id() {
        return hosR_id;
    }

    public void setHosR_id(Integer hosR_id) {
        this.hosR_id = hosR_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_keshi() {
        return d_keshi;
    }

    public void setD_keshi(String d_keshi) {
        this.d_keshi = d_keshi;
    }

    public Date getHosR_dateStart() {
        return hosR_dateStart;
    }

    public void setHosR_dateStart(Date hosR_dateStart) {
        this.hosR_dateStart = hosR_dateStart;
    }

    public Date getGetHosR_dateEnd() {
        return getHosR_dateEnd;
    }

    public void setGetHosR_dateEnd(Date getHosR_dateEnd) {
        this.getHosR_dateEnd = getHosR_dateEnd;
    }
}
