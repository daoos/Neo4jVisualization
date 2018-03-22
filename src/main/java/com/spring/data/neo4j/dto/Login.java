package com.spring.data.neo4j.dto;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/3/17.
 */
@NodeEntity
public class Login {
    @GraphId
    private Long id ;
    //登录的用户名
    private String user;
    //日志生成时间
    private Date time;
    //应用的协议
    private String proto;
    //目的IP
    private String dip;
    private int dport;
    //源IP
    private String sip;
    private int sport;
    //登录结果(成功或失败)
    private String state;

    public Login(){}
    public Login(String user, Date time, String proto, String dip, int dport, String sip, int sport, String state) {
        this.user = user;
        this.time = time;
        this.proto = proto;
        this.dip = dip;
        this.dport = dport;
        this.sip = sip;
        this.sport = sport;
        this.state = state;
    }

    public Login(String user, String proto, String dip, int dport, String sip, int sport, String state) {
        this.user = user;
        this.time = new Date();
        this.proto = proto;
        this.dip = dip;
        this.dport = dport;
        this.sip = sip;
        this.sport = sport;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getProto() {
        return proto;
    }

    public void setProto(String proto) {
        this.proto = proto;
    }

    public String getDip() {
        return dip;
    }

    public void setDip(String dip) {
        this.dip = dip;
    }

    public int getDport() {
        return dport;
    }

    public void setDport(int dport) {
        this.dport = dport;
    }

    public String getSip() {
        return sip;
    }

    public void setSip(String sip) {
        this.sip = sip;
    }

    public int getSport() {
        return sport;
    }

    public void setSport(int sport) {
        this.sport = sport;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
