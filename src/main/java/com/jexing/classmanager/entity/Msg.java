package com.jexing.classmanager.entity;

import java.util.HashMap;
import java.util.Map;


public class Msg {

    private String info;

    private Map<String,Object> data=new HashMap<>();

    private boolean isSuccess;
    public static Msg success(){
        Msg msg = new Msg();
        msg.info="success!";
        msg.isSuccess=true;
        return msg;
    }
    public static Msg fail(){
        Msg msg = new Msg();
        msg.info="fail!";
        msg.isSuccess=false;
        return msg;
    }
    public Msg success(String info){
        Msg msg = new Msg();
        msg.info=info;
        msg.isSuccess=true;
        return msg;
    }
    public Msg add(String key, Object data){
        this.data.put(key,data);
        return this;
    }
    public static Msg fail(String info){
        Msg msg = new Msg();
        msg.info=info;
        msg.isSuccess=false;
        return msg;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
