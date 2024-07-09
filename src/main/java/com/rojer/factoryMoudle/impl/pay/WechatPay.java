package com.rojer.factoryMoudle.impl.pay;

import com.rojer.factoryMoudle.impl.pay.abs.AbstractPaymentStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 具体的策略实现WechatPay
 */
@Component
public class WechatPay extends AbstractPaymentStrategy {

    // 可注入别的类
    // @Autowired
    // private Pay pay;

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("进行了微信支付");
    }
}
