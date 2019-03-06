package com.test.designmode.facade8;

import org.junit.Test;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class DemoTest {
/**
 * 外观模式测试（相当于封装，让系统层的调用更清晰）
 */
@Test
public void facadeTest() {
    BigSystem bigSystem = new BigSystem();
    bigSystem.menthod();
}
}
