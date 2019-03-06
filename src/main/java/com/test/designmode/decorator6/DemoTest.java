package com.test.designmode.decorator6;

import org.junit.Test;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class DemoTest {
    /**
     * 装饰者模式测试
     */
    @Test
    public void decorator() {
        /**
         * 老人只要吃饭就行
         */
        People oldPeople=new OldPeople();
        oldPeople.eat();
        System.out.println("-------------------------------");
        /**
         * 而新人不仅要有老人的特性还有新人应该做的事情
         */
        People newPeople=new NewPeople(oldPeople);
        newPeople.eat();
    }
}
