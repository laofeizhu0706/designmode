package com.test.designmode.strategy11;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class ConcreteStrategy1 implements IStrategy {
    @Override
    public void doSomething() {
        System.out.println("具体策略1");
    }
}
