package com.leonard.anzwholesalecodingchallenge.enums;

/**
 * @author limeng
 * @date 2019/9/4
 */

public enum AccountTypeEnum {
    /**
     * account type enum
     */
    SAVINGS("Savings"), CURRENT("Current");

    private String value;

    AccountTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
