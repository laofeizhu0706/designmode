package com.test.designmode.builder4;

/**
 * @author 老肥猪
 * @since 2019/3/2
 * 设备生产接口
 */
public interface DeviceBuilder<T> {

    /**
     * 原型讨论
     */
    void doDiscussion();

    /**
     * 原型设计
     */
    void doDesign();

    /**
     * 生产
     */
    T doProduct();
}
