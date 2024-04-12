package com.example.demo.base.entity;

import lombok.Data;

/**
 * 用户信息
 */
@Data
public class Account {

    /**
     * id
     */
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录密码
     */
    private String userPassword;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 用户类型
     */
    private String type;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 会员等级
     */
    private String rank;

}
