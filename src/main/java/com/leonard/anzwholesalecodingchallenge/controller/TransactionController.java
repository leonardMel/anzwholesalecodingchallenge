package com.leonard.anzwholesalecodingchallenge.controller;

import com.leonard.anzwholesalecodingchallenge.dto.TransactionInfo;
import com.leonard.anzwholesalecodingchallenge.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author limeng
 * @date 2019/9/4
 */

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transaction/{accountNumber}")
    public List<TransactionInfo> getTransactionList(@PathVariable Integer accountNumber) {
        return transactionService.getTransactionListByAccountNumber(accountNumber);
    }

}
