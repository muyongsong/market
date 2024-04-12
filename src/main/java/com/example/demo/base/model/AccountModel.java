package com.example.demo.base.model;

import lombok.Data;

/**
 * @author muyongsong
 * @version 1.0
 * @package com.example.demo.base.model
 * @date 2023/4/11 16:06
 * @description 用户模型
 */
@Data
public class AccountModel {

    private String userName;

    private String userPassword;

    private String rank;

    private String telephone;

    private String email;
}



