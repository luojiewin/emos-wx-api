package com.landx.emos.wx.util;

import lombok.Data;

import java.util.Map;

//统一封装返回给客户端的数据
@Data
public class R {
    private int code;
    private Map data;
    private String msg;

    //正常200，无返回数据
    public static R ok() {
        R r = new R();
        r.code = 200;
        r.msg = "请求成功";
        return r;
    }

    //正常200，由返回数据
    public static R ok(Map data) {
        R r = new R();
        r.code = 200;
        r.msg = "请求成功";
        r.data = data;
        return r;
    }

    //业务异常提示
    public static R exception(Exception e) {
        R r = new R();
        r.code = 500;
        r.msg = e.getMessage();
        return r;
    }

    //系统异常
    public static R exception(int code, String msg) {
        R r = new R();
        r.code = code;
        r.msg = msg;
        return r;
    }


}


