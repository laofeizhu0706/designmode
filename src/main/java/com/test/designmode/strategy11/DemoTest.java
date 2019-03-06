package com.test.designmode.strategy11;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class DemoTest {

@Test
public void strategyTest() {
    Context context = new Context(new ConcreteStrategy1());
    context.execute();
    context = new Context(new ConcreteStrategy2());
    context.execute();

    TreeSet<String> treeSet=new TreeSet<>();
}
}
