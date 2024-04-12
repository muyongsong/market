package com.example.demo.base.service;

import com.example.demo.base.model.AccountModel;
import com.example.demo.base.parameters.LoginParameter;

/**
 * @author muyongsong
 * @version 1.0
 * @package com.example.demo.base.service
 * @date 2023/4/11 15:59
 * @description 用户服务接口
 */
public interface AccountService {


    /**
     * 通过userName获取
     * @return Account
     */
    String getByUserId(LoginParameter loginParameter);

    /**
     * 创建用户
     * @param accountModel
     */
    void createUser(AccountModel accountModel);


    /**
     * 根据用户名查询用户
     * @param userName 用户名称
     * @return 用户信息
     */
    AccountModel getByUserName(String userName);
}