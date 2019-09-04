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
public class AccountInfo implements Serializable {
    private static final long serialVersionUID = 3599121540363573324L;

    private Integer accountNumber;
    private String accountName;
    private String accountType;
    private LocalDate balanceDate;
    private String currency;
    private Double balance;
}
