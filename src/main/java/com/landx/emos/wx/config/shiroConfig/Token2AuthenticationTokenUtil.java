package com.landx.emos.wx.config.shiroConfig;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * 工具类，将客户端请求中的token转换为shiro框架可识别的AuthenticationToken类型
 */
@Data
public class Token2AuthenticationTokenUtil implements AuthenticationToken {

    private String token;

    public Token2AuthenticationTokenUtil(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }
}
