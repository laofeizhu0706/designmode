package com.test.designmode.state22;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class ConcreteStateB implements State {
    @Override
    public void behavior() {
        System.out.println("话费高于0，可以打电话");
    }
}
