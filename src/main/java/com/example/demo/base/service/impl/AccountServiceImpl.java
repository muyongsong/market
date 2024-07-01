package com.example.demo.base.service.impl;

import com.example.demo.base.entity.Account;
import com.example.demo.base.entity.AccountDetail;
import com.example.demo.base.enums.AccountRankEnum;
import com.example.demo.base.enums.AccountTypeEnum;
import com.example.demo.base.mapper.AccountDetailMapper;
import com.example.demo.base.mapper.AccountMapper;
import com.example.demo.base.model.AccountModel;
import com.example.demo.base.parameters.LoginParameter;
import com.example.demo.base.service.AccountService;
import com.example.demo.global.config.GlobalException;
import com.example.demo.global.util.JwtTokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.StringTokenizer;
import java.util.UUID;

/**
 * @author muyongsong
 * @version 1.0
 * @package com.example.demo.base.service.impl
 * @date 2023/4/11 16:00
 * @description 用户服务实现类
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private AccountDetailMapper accountDetailMapper;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    private final static String  SUPER_ACCOUNT_LOGIN= "SUPER";

    /**
     * 通过userName获取
     *
     * @return Account
     */
    @Override
    public String getByUserId(LoginParameter loginParameter) {

        if (StringUtils.isEmpty(loginParameter.getUserName())) {
            throw new GlobalException(201, "用户名为空");
        }
        if (StringUtils.isEmpty(loginParameter.getUserPassword())) {
            throw new GlobalException(201, "用户密码为空");
        }
        // 查询用户信息
        Account account = accountMapper.getAccountByUserName(loginParameter.getUserName());
        if (ObjectUtils.isEmpty(account)) {
            throw new GlobalException(201, "不存在该用户信息");
        }
        // 若为后台登录，则查看是否有权限
        if (SUPER_ACCOUNT_LOGIN.equals(loginParameter.getType())) {
            if(!account.getType().equals(AccountTypeEnum.SUPER.getValue())){
                throw new GlobalException(201, "该用户没有后台权限");
            }
        }
        if (account.getUserPassword().equals(loginParameter.getUserPassword())) {
            return jwtTokenUtil.getToken(loginParameter.getUserName(),loginParameter.getUserPassword());
        }
        return null;
    }

    /**
     * 创建用户
     *
     * @param accountModel
     */
    @Override
    public void createUser(AccountModel accountModel) {

        // 创建用户主信息
        if (StringUtils.isEmpty(accountModel.getUserName())) {
            throw new GlobalException(201, "用户名为空");
        }
        if (StringUtils.isEmpty(accountModel.getUserPassword())) {
            throw new GlobalException(201, "用户密码为空");
        }
        Account account = new Account();
        account.setId(UUID.randomUUID().toString());
        BeanUtils.copyProperties(accountModel, account);

        accountMapper.createAccount(account);

        // 创建用户详情信息
        AccountDetail accountDetail = new AccountDetail();
        accountDetail.setId(UUID.randomUUID().toString());
        accountDetail.setAccountId(account.getId());
        accountDetail.setEmail(accountModel.getEmail());
        accountDetail.setTelephoneNumber(accountModel.getTelephone());
        // 用户新建默认是普通会员
        accountDetail.setRank(AccountRankEnum.COMMON.name());

        accountDetailMapper.addAccountDetail(accountDetail);
    }

    /**
     * 根据用户名查询用户
     *
     * @param userName 用户名称
     * @return 用户信息
     */
    @Override
    public AccountModel getByUserName(String userName) {
        if (StringUtils.isEmpty(userName)) {
            throw new GlobalException(201, "用户名为空");
        }

        // 根据用户名称插叙用户信息
        Account account = accountMapper.getAccountByUserName(userName);
        if (!ObjectUtils.isEmpty(account)) {
            AccountModel accountModel = new AccountModel();
            // 用户实体转换成用户info
            BeanUtils.copyProperties(account, accountModel);
            accountModel.setRank(AccountRankEnum.valueOf(accountModel.getRank()).getValue());
            return  accountModel;

        }
        return null;
    }

    @Override
    @Async
    public void test(int i) {

        System.out.println("线程" + Thread.currentThread().getName() + " 执行任务：" + i);
    }
}