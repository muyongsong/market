package com.example.demo.base.parameters;

import lombok.Data;

/**
 * @author muyongsong
 * @version 1.0
 * @package com.example.demo.base.parameters
 * @date 2023/12/14 17:54
 * @description 用户登录参数
 */
@Data
public class LoginParameter {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 登录类型
     */
    private String type;
}