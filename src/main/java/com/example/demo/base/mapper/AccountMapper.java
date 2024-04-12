package com.example.demo.base.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.base.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author muyongsong
 * @version 1.0
 * @package com.example.demo.base.mapper
 * @date 2023/4/10 14:12
 * @description 用户mapper接口
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    /**
     * 通过userName查询
     * @param userName
     * @return
     */
     Account getAccountByUserName(@Param("userName") String userName);


    /**
     * 创建用户
     * @param account
     */
    void createAccount(Account account);


}