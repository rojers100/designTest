package com.rojer.factoryMoudle.moudle;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PayModule {

    private Integer payType;

    private BigDecimal payAmount;
}
