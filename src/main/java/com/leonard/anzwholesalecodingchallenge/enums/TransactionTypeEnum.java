package com.leonard.anzwholesalecodingchallenge.enums;

/**
 * @author limeng
 * @date 2019/9/4
 */

public enum TransactionTypeEnum {
    /**
     * transaction type, credit or debit
     */
    CREDIT("Credit"), DEBIT("Debit");

    private String value;

    TransactionTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
