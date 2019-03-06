package com.test.designmode.visitor16;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class ConcreteElement2 extends Element {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void doSomething() {
        System.out.println("这是访问者1");
    }
}
