package com.leonard.anzwholesalecodingchallenge.service;

import com.leonard.anzwholesalecodingchallenge.dto.TransactionInfo;
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
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    public void testGetTransactionList() {
        List<TransactionInfo> transactionInfoList = transactionService.getTransactionListByAccountNumber(585309209);
        Assert.assertEquals(5, transactionInfoList.size());
        Assert.assertEquals("TransactionInfo(accountNumber=585309209, accountName=SGSavings726, valueDate=2018-11-08, currency=SGD, debitAmount=0.0, creditAmount=9540.98, transactionType=Credit, transactionNarrative=)",
                transactionInfoList.get(0).toString());
    }

    @Test
    public void testGetTransactionListWithNotExistAccountNumber() {
        List<TransactionInfo> transactionInfoList = transactionService.getTransactionListByAccountNumber(1234567);
        Assert.assertEquals(0, transactionInfoList.size());
    }

}
