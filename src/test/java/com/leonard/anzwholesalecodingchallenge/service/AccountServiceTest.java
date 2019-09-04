package com.leonard.anzwholesalecodingchallenge.service;

import com.leonard.anzwholesalecodingchallenge.dto.AccountInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author limeng
 * @date 2019/9/4
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testGetAccountList() {
        List<AccountInfo> accountInfoList = accountService.getAccountList();
        Assert.assertEquals(8, accountInfoList.size());
        Assert.assertEquals("AccountInfo(accountNumber=585309209, accountName=SGSavings726, accountType=Savings, balanceDate=2018-11-08, currency=SGD, balance=84327.51)",
                accountInfoList.get(0).toString());
    }
}
