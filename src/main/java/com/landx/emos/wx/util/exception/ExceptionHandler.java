package com.landx.emos.wx.util.exception;

import com.landx.emos.wx.util.R;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServlet;

/**
 * @ExceptionHandler: 该注解作用于方法上，
 * 可以捕获到 controller 中抛出的一些自定义异常，统一进行处理，一般用于进行一些特定的异常处理。
 */
@Data
@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(EmosException.class)
    public R exceptionHandler(HttpServlet httpServlet, EmosException e){
        log.error("ErrorCode:"+e.getCode());
        log.error("ErrorMsg:"+e.getMsg());
        return  R.BussinessException(e);
    }

}
