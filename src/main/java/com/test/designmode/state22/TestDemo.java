package com.test.designmode.state22;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class TestDemo {
/**
 * 状态模式测试
 */
@Test
public void stateTest() {
    Context context = new Context();
    context.setBill(new BigDecimal(100));
    System.out.println("当前花费："+context.getBill()+"元");
    context.handle();
    context.setBill(new BigDecimal(0));
    System.out.println("当前花费："+context.getBill()+"元");
    context.handle();
    context.setBill(new BigDecimal(50));
    System.out.println("当前花费："+context.getBill()+"元");
    context.handle();
}
}
