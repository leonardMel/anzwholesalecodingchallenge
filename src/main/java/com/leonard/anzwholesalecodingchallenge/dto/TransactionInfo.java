package com.leonard.anzwholesalecodingchallenge.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author limeng
 * @date 2019/9/4
 */

@Data
@Builder
public class TransactionInfo implements Serializable {
    private static final long serialVersionUID = -7803325684925629868L;

    private Integer accountNumber;
    private String accountName;
    private LocalDate valueDate;
    private String currency;
    private Double debitAmount;
    private Double creditAmount;
    private String transactionType;
    private String transactionNarrative;
}
