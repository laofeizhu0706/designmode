package com.test.designmode.adapter5;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class Adapter2 implements Target{

    private Adaptee adaptee;
    public Adapter2(Adaptee adaptee) {
     this.adaptee=adaptee;
    }
    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
