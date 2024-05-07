package com.landx.emos.wx.config.shiroConfig;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * shiro 认证、授权的业务规则
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 授权，验证权限时调用
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //todo 查询用户权限列表
        //todo 把权限列表添加到info对象
        return info;
    }

    /**
     * 认证，登录时调用
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //todo 获取令牌中userid,然后监测该账户是否被冻结
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo();
        //todo 往info对象中添加用户信息，token信息
        return info;
    }
}
