package com.landx.emos.wx.util.exception;

import lombok.Data;

/**
 * 公共的业务逻辑错误,可以自定义异常的code和msg
 */

@Data
public class EmosException extends RuntimeException{

    private int code;
    private String msg;

    public EmosException(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
