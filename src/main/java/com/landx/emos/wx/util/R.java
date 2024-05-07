package com.landx.emos.wx.util;

import com.landx.emos.wx.util.exception.EmosException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

//统一封装返回给客户端的数据
@ApiModel(value = "接口数据返回标准格式")
@Data
public class R {
    @ApiModelProperty("返回码")
    private int code;

    @ApiModelProperty("返回数据")
    private Map data;

    @ApiModelProperty("描述")
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
    public static R BussinessException(EmosException e) {
        R r = new R();
        r.code = e.getCode();
        r.msg = e.getMessage();
        return r;
    }
}


