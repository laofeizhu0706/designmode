package com.test.designmode.bridge9;

import org.junit.Test;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class TestDemo {
/**
 * 桥接模式测试
 */
@Test
public void bridgeTest() {
    Implementor impl=new ServiceImpl2();
    AbstractionService service=new Service(impl);
    service.operation();
    service.otherOperation();
}
}
