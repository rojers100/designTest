package com.rojer.factoryMoudle.impl;

import com.rojer.factoryMoudle.impl.pay.AliPay;
import com.rojer.factoryMoudle.impl.pay.UnionPay;
import com.rojer.factoryMoudle.impl.pay.WechatPay;
import com.rojer.factoryMoudle.moudle.PayEnum;
import com.rojer.factoryMoudle.moudle.PayModule;
import com.rojer.factoryMoudle.impl.pay.inter.PaymentStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PayImpl {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PayModule module) {
        if (PayEnum.ALIPAY.getCode() == module.getPayType()) {
            paymentStrategy = new AliPay();
        } else if (PayEnum.WECHATPAY.getCode() == module.getPayType()){
            paymentStrategy = new WechatPay();
        } else if (PayEnum.UNIONPAY.getCode() == module.getPayType()) {
            paymentStrategy = new UnionPay();
        } else {
            throw new IllegalArgumentException("无效的支付类型");
        }
    }


    public void pay(BigDecimal money) {
        if (paymentStrategy == null) {
            throw new IllegalArgumentException("支付类型未设置");
        }
        paymentStrategy.pay(money);
    }
}
