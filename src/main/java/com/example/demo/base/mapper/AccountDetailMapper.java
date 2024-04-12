package com.example.demo.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.base.entity.AccountDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author muyongsong
 * @version 1.0
 * @package com.example.demo.base.mapper
 * @date 2023/8/29 11:04
 * @description 用户详细信息
 */
@Mapper
public interface AccountDetailMapper  extends BaseMapper<AccountDetail> {


    /**
     * 新建用户明细
     * @param accountDetail
     */
    void  addAccountDetail(AccountDetail accountDetail);



}