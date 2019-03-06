package com.test.designmode.chain19;

import org.junit.Test;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class TestDemo {

/**
 * 责任链模式测试方法
 */
@Test
public void chainTest() {
    Handler handler1 = new ConcreteHandler1();
    Handler handler2 = new ConcreteHandler2();
    Handler handler3 = new ConcreteHandler3();

    handler1.setNextHandler(handler2);
    handler2.setNextHandler(handler3);

    Response response = handler1.handleRequest(new Request(new Level(4)));
}
}
