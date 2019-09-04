package com.leonard.anzwholesalecodingchallenge.entity;

import com.leonard.anzwholesalecodingchallenge.enums.CurrencyEnum;
import com.leonard.anzwholesalecodingchallenge.enums.TransactionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author limeng
 * @date 2019/9/4
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "account_transaction")
public class Transaction implements Serializable {
    private static final long serialVersionUID = -6912440160311138696L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", nullable = false)
    private Integer accountNumber;

    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Column(name = "value_date", nullable = false)
    private LocalDate valueDate;

    @Column(name = "currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;

    @Column(name = "debit_amount")
    private Double debitAmount;

    @Column(name = "credit_amount")
    private Double creditAmount;

    @Column(name = "transaction_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum transactionType;

    @Column(name = "transaction_narrative")
    private String transactionNarrative;

}
