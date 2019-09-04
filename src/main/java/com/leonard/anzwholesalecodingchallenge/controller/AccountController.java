package com.leonard.anzwholesalecodingchallenge.controller;

import com.leonard.anzwholesalecodingchallenge.dto.AccountInfo;
import com.leonard.anzwholesalecodingchallenge.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author limeng
 * @date 2019/9/4
 */

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * TODO: get account list by user
     * @return List
     */
    @GetMapping("/account")
    public List<AccountInfo> getAccountList() {
        return accountService.getAccountList();
    }

}
