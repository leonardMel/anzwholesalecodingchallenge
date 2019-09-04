package com.leonard.anzwholesalecodingchallenge.repository;

import com.leonard.anzwholesalecodingchallenge.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author limeng
 * @date 2019/9/4
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
