package com.rojer.factoryMoudle.impl.pay;

import com.rojer.factoryMoudle.impl.pay.abs.AbstractPaymentStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 具体的策略实现UnionPay
 */
@Component
public class UnionPay extends AbstractPaymentStrategy {
    @Override
    public void pay(BigDecimal amount) {
        System.out.println("进行了银联支付");
    }
}
