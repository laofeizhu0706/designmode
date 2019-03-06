package com.test.designmode.builder4;

import org.junit.Test;

/**
 * @author 老肥猪
 * @since 2019/3/2
 * 指挥者
 */
public class Director {
    @Test
    public void builderTest() {
        DeviceBuilder deviceBuilder=new ComputerBuilder();
        deviceBuilder.doDesign();
        deviceBuilder.doDiscussion();
        deviceBuilder.doProduct();
        deviceBuilder=new MobileBuilder();
        deviceBuilder.doDesign();
        deviceBuilder.doDiscussion();
        Object mobile = deviceBuilder.doProduct();
        System.out.println(mobile);
    }
}
