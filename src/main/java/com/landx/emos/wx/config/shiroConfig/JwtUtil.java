package com.landx.emos.wx.config.shiroConfig;


/**
 * jwt工具类，提供tocken创建、token验证，token中获取用户id三个方法
 *
 */

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.landx.emos.wx.util.exception.EmosException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Slf4j
public class JwtUtil {

    //密钥
    @Value("${emos.jwt.secret}")
    private String secret;

    //过期时间（天）
    @Value("${emos.jwt.expire}")
    private int expire;

    /**
     * 创建token
     * @param userId
     * @return
     */
    public String createToken(int userId) {
        Date date = DateUtil.offset(new Date(), DateField.DAY_OF_YEAR, expire).toJdkDate();
        Algorithm algorithm = Algorithm.HMAC256(secret); //创建加密算法对象
        JWTCreator.Builder builder = JWT.create();
        String token = builder.withClaim("userId", userId).withExpiresAt(date).sign(algorithm);
        return token;
    }

    /**
     * 获取用户id
     * @param token
     * @return
     */
    public int getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asInt();
        } catch (Exception e) {
            throw new EmosException(500,"令牌无效");
        }
    }

    //验证token
    public void verifierToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret); //创建加密算法对象
        JWTVerifier verifier = JWT.require(algorithm).build();
        verifier.verify(token);
    }
}

