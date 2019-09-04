package com.leonard.anzwholesalecodingchallenge.repository;

import com.leonard.anzwholesalecodingchallenge.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author limeng
 * @date 2019/9/4
 */

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByAccountNumber(Integer accountNumber);
}
