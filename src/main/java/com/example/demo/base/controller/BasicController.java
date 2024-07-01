package com.example.demo.base.controller;

import com.example.demo.base.model.AccountModel;
import com.example.demo.base.parameters.LoginParameter;
import com.example.demo.base.service.AccountService;
import com.example.demo.global.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/basic")
public class BasicController {

    @Resource
    private AccountService accountService;

    /**
     * 用户登陆
     * @param loginParameter
     * @return
     */
    @PostMapping("/login")
    public Result<String> checkAccount(@RequestBody LoginParameter loginParameter){
        return Result.ok(accountService.getByUserId(loginParameter));
    }


    @GetMapping("/account/{userName}")
    public Result<AccountModel> getByUserName(@PathVariable("userName") String userName){
        return Result.ok(accountService.getByUserName(userName));
    }

    /**
     * 创建用户
     * @param accountModel
     * @return
     */
    @PostMapping("/create")
    public Result<Boolean> createAccount(@RequestBody AccountModel accountModel){
        accountService.createUser(accountModel);
        return Result.ok(Boolean.TRUE);
    }


    /**
     * 创建用户
     * @return
     */
    @PostMapping("/test")
    public Result<Boolean> test(){
        for (int i = 0; i <= 10; i++) {
            accountService.test(i);
        }
        return Result.ok(Boolean.TRUE);
    }
}
