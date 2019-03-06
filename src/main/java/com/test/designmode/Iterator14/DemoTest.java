package com.test.designmode.Iterator14;

import org.junit.Test;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class DemoTest {

    /**
     * 迭代模式测试
     */
    @Test
    public void lteratorTest() {
        Aggregate<String> aggregate=new ConcreteAggregate<>();
        aggregate.add("张晓聪");
        aggregate.add("小蓝");
        aggregate.add("涂松凯");
        Iterator iterator = aggregate.iterator();
        while (iterator.hasHash()) {
            String obj = (String) iterator.next();
            System.out.println(obj);
        }
    }

}
