package com.scut.springbootjwt.controller;

import com.alibaba.fastjson.JSONObject;
import com.scut.springbootjwt.annotation.UserLoginToken;
import com.scut.springbootjwt.entity.User;
import com.scut.springbootjwt.service.TokenService;
import com.scut.springbootjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 焦旭峰
 * @site www.scut.com
 * @company 华南理工大学
 * @create 2021-06-16 14:43
 */
@RestController
@RequestMapping("api")
public class UserApi {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    //登录
    @PostMapping("/login")
    public Object login( User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase = userService.findByUsername(user);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }

    @GetMapping("/get")
    public Object get(String username){
        JSONObject jsonObject=new JSONObject();
        User userForBase = userService.findByUsername1(username);
        System.out.println(userForBase);
        return null;
    }
}
