package com.scut.springbootjwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.scut.springbootjwt.entity.User;
import org.springframework.stereotype.Service;


/**
 * @author 焦旭峰
 * @site www.scut.com
 * @company 华南理工大学
 * @create 2021-06-16 14:43
 */
@Service("TokenService")
public class TokenService {
    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getId())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
