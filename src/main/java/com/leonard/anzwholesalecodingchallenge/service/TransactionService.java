package com.leonard.anzwholesalecodingchallenge.service;

import com.leonard.anzwholesalecodingchallenge.dto.TransactionInfo;
import com.leonard.anzwholesalecodingchallenge.entity.Transaction;
import com.leonard.anzwholesalecodingchallenge.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author limeng
 * @date 2019/9/4
 */

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<TransactionInfo> getTransactionListByAccountNumber(Integer accountNumber) {
        return transactionRepository.findAllByAccountNumber(accountNumber).stream()
                .map(this::convertTransactionEntityToDTO)
                .collect(Collectors.toList());
    }

    private TransactionInfo convertTransactionEntityToDTO(Transaction transactionEntity) {
        return TransactionInfo.builder()
                .accountNumber(transactionEntity.getAccountNumber())
                .accountName(transactionEntity.getAccountName())
                .valueDate(transactionEntity.getValueDate())
                .currency(transactionEntity.getCurrency().getValue())
                .debitAmount(transactionEntity.getDebitAmount())
                .creditAmount(transactionEntity.getCreditAmount())
                .transactionType(transactionEntity.getTransactionType().getValue())
                .transactionNarrative(transactionEntity.getTransactionNarrative())
                .build();
    }
}
