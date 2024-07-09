package com.rojer.factoryMoudle.impl.pay;

import com.rojer.factoryMoudle.impl.pay.abs.AbstractPaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 具体的策略实现AliPay
 */
@Component
public class AliPay extends AbstractPaymentStrategy {

    // 可注入别的类
    // @Autowired
    // private Pay pay;

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("进行了阿里支付");
    }
}
