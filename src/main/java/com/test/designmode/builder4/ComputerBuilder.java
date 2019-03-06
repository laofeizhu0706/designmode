package com.test.designmode.builder4;

import java.math.BigDecimal;

/**
 * @author 老肥猪
 * @since 2019/3/2
 *
 * 电脑建筑者
 */
public class ComputerBuilder implements DeviceBuilder<Computer> {
    @Override
    public void doDiscussion() {
        System.out.println("电脑原型讨论");
    }

    @Override
    public void doDesign() {
        System.out.println("电脑模型的设计");
    }

    @Override
    public Computer doProduct() {
        System.out.println("电脑生产者在生产");
        return new Computer("电脑",new BigDecimal(4999),"amd 1600x","16 g");
    }
}
