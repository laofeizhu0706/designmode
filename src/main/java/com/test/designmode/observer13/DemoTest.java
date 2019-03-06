package com.test.designmode.observer13;

import org.junit.Test;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class DemoTest {
    @Test
    public void observerTest() {
        AbstractSubject subject=new ConcreteSubject();
        subject.addObserver(new ObserverImpl2());
        subject.addObserver(new ObserverImpl1());
        subject.addObserver(new ObserverImpl2());
        subject.doSomething();
    }
}
