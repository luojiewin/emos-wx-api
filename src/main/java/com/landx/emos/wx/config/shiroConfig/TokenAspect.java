package com.landx.emos.wx.config.shiroConfig;

import com.landx.emos.wx.util.R;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 在写OAuth2Filter的时候，把更新后的令牌写到ThreadLocalToken里面的ThreadLocal。
 * 要创建AOP切面类，拦截所有Web方法的返回值，在返回的R对象中添加更新后的令牌。
 */
@Aspect
@Component
public class TokenAspect {

    @Autowired
    private ThreadLocalToken threadLocalToken;

    @Pointcut("execution(public * com.landx.emos.wx.controller.*.*(..)))")
    public void aspect() {

    }

    @Around("aspect()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        R r = (R) point.proceed(); //方法执行结果
        String token = threadLocalToken.getToken();
        //如果ThreadLocal中存在Token，说明是更新的Token
        if (token != null) {
            r.getData().put("token",token);
            threadLocalToken.clear();
        }
        return r;
    }
}
