package com.test.designmode.adapter5;

import org.junit.Test;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class DemoTest {
    /**
     * 类适配器测试
     */
    @Test
    public void classAdapter() {
        Target target = new Adapter1();
        target.request();
    }

    /**
     * 对象适配器
     */
    @Test
    public void objectAdapter() {
        /**
         * 通过对象委托完成
         */
        Target target = new Adapter2(new Adaptee());
        target.request();
    }
}
