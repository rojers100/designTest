package com.rojer.factoryMoudle.impl.pay.abs;

import com.rojer.factoryMoudle.impl.pay.inter.PaymentStrategy;

import java.math.BigDecimal;

/**
 * 设计模式之模板方法
 * 定义了支付的模板方法
 */
public abstract class AbstractPaymentStrategy implements PaymentStrategy {

    // 模板方法
    public final void commonPay(BigDecimal amount) {
        // 检测金额未合法数字
        check(amount);

        // 扩展支付
        pay(amount);

        // 可以继续扩展模板
    }

    // 声明未private，该方法不可被重写，必须按这个进行
    private void check(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("无效的金额！");
        }
    }
}
