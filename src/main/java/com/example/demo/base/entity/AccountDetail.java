package com.example.demo.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author muyongsong
 * @version 1.0
 * @package com.example.demo.base.entity
 * @date 2023/8/29 10:44
 * @description 用户详细信息
 */
@Data
@TableName(value = "accountDetailRecord")
public class AccountDetail {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 电话号码
     */
    private String telephoneNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 个性签名
     */
    private String personalSignature;

    /**
     * 用户等级
     */
    private String rank;

    /**
     * 用户主键ID
     */
    private String accountId;
}