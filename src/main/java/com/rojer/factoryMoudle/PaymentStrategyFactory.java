package com.rojer.factoryMoudle;

import com.rojer.factoryMoudle.impl.pay.AliPay;
import com.rojer.factoryMoudle.impl.pay.UnionPay;
import com.rojer.factoryMoudle.impl.pay.WechatPay;
import com.rojer.factoryMoudle.impl.pay.abs.AbstractPaymentStrategy;
import com.rojer.factoryMoudle.moudle.PayEnum;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 设计模式之简单工厂
 */
@Component
public class PaymentStrategyFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * 使用简单工厂生成具体的支付对学校
     *
     * @param payType 支付类型
     * @return AbstractPaymentStrategy 抽象支付类
     */
    public AbstractPaymentStrategy getPaymentStrategy(Integer payType) {
        if (PayEnum.ALIPAY.getCode() == payType) {
            return applicationContext.getBean(AliPay.class);
        } else if (PayEnum.WECHATPAY.getCode() == payType){
            return applicationContext.getBean(WechatPay.class);
        } else if (PayEnum.UNIONPAY.getCode() == payType) {
            return applicationContext.getBean(UnionPay.class);
        } else {
            throw new IllegalArgumentException("无效的支付类型");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
