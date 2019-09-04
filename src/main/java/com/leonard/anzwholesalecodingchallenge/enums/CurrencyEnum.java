package com.leonard.anzwholesalecodingchallenge.enums;

/**
 * @author limeng
 * @date 2019/9/4
 */

public enum CurrencyEnum {
    /**
     * Currency enum
     */
    SGD("SGD"), AUD("AUD");

    private String value;

    CurrencyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
