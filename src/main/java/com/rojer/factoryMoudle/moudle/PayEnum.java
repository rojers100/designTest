package com.rojer.factoryMoudle.moudle;

public enum PayEnum {
    ALIPAY(1, "Alipay"),
    WECHATPAY(2, "WeChat Pay"),
    UNIONPAY(3, "UnionPay");

    private final int code;
    private final String description;

    PayEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
