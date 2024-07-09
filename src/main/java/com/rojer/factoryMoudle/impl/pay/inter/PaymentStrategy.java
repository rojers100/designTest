package com.rojer.factoryMoudle.impl.pay.inter;

import java.math.BigDecimal;

/**
 * 策略模式接口
 */
public interface PaymentStrategy {
    void pay(BigDecimal amount);
}
