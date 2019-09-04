package com.leonard.anzwholesalecodingchallenge.service;

import com.leonard.anzwholesalecodingchallenge.dto.AccountInfo;
import com.leonard.anzwholesalecodingchallenge.entity.Account;
import com.leonard.anzwholesalecodingchallenge.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author limeng
 * @date 2019/9/4
 */

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    /**
     * TODO: user authentication
     * @return List
     */
    public List<AccountInfo> getAccountList() {
        return accountRepository.findAll().stream()
                .map(this::convertAccountEntityToDTO).collect(Collectors.toList());
    }

    private AccountInfo convertAccountEntityToDTO(Account accountEntity) {
        return AccountInfo.builder()
                .accountName(accountEntity.getAccountName())
                .accountNumber(accountEntity.getAccountNumber())
                .accountType(accountEntity.getAccountType().getValue())
                .balanceDate(accountEntity.getBalanceDate())
                .currency(accountEntity.getCurrency().getValue())
                .balance(accountEntity.getBalance())
                .build();
    }


}
