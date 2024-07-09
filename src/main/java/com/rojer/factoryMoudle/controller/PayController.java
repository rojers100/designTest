package com.rojer.factoryMoudle.controller;

import com.rojer.factoryMoudle.PaymentStrategyFactory;
import com.rojer.factoryMoudle.impl.pay.AliPay;
import com.rojer.factoryMoudle.impl.pay.UnionPay;
import com.rojer.factoryMoudle.impl.pay.WechatPay;
import com.rojer.factoryMoudle.impl.pay.abs.AbstractPaymentStrategy;
import com.rojer.factoryMoudle.moudle.PayModule;
import com.rojer.factoryMoudle.impl.pay.inter.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PayController {

    @Autowired
    private PaymentStrategyFactory paymentStrategyFactory;

    /**
     * 普通写发法
     * @param module
     */
    @PostMapping("/online/pay1")
    public void pay(@RequestBody PayModule module) {
        PaymentStrategy paymentStrategy;
        switch (module.getPayType()) {
            case 1:
                paymentStrategy = new AliPay();
                break;
            case 2:
                paymentStrategy = new WechatPay();
                break;
            case 3:
                paymentStrategy = new UnionPay();
                break;
            default:
                throw new IllegalArgumentException("无效的支付类型");
        }
        paymentStrategy.pay(module.getPayAmount());
    }

    /**
     * 改造后写法
     * @param module
     */
    @PostMapping("/online/pay2")
    public void pay2(@RequestBody PayModule module) {
        AbstractPaymentStrategy strategy = paymentStrategyFactory.getPaymentStrategy(module.getPayType());
        strategy.commonPay(module.getPayAmount());
    }

}
