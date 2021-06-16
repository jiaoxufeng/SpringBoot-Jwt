package com.scut.springbootjwt.mapper;

import com.scut.springbootjwt.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 焦旭峰
 * @site www.scut.com
 * @company 华南理工大学
 * @create 2021-06-16 14:43
 */
public interface UserMapper {
    User findByUsername(@Param("username") String username);
    User findUserById(@Param("Id") String Id);
}
