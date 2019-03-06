package com.test.designmode.adapter5;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class Adapter1 extends Adaptee implements Target {
    @Override
    public void request() {
        super.specificRequest();
    }
}