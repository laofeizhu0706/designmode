package com.test.designmode.flyweight21;

import org.junit.Test;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class DemoTest {
    /**
     * 享元模式测试（）
     */
    @Test
    public void flyWeightTest() {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight fly = factory.factory(new Character('a'));
        fly.operation("外蕴测试第一次");

        fly = factory.factory(new Character('b'));
        fly.operation("外蕴测试第二次");

        fly = factory.factory(new Character('a'));
        fly.operation("外蕴测试第三次");
    }
}
