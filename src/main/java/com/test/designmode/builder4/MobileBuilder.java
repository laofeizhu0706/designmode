package com.test.designmode.builder4;

import java.math.BigDecimal;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class MobileBuilder implements DeviceBuilder<Mobile> {
    @Override
    public void doDiscussion() {
        System.out.println("手机原型讨论");
    }

    @Override
    public void doDesign() {
        System.out.println("手机模型的设计");
    }

    @Override
    public Mobile doProduct() {
        System.out.println("手机生产者在生产");
        return new Mobile("手机",new BigDecimal(2999),"骁龙855","4800万像素");
    }
}
