package com.test.designmode.state22;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class ConcreteStateA implements State {
    @Override
    public void behavior() {
        System.out.println("话费低于0，不能打电话");
    }
}
