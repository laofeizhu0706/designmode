package com.test.designmode.visitor16;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public abstract class Element {
    public abstract void accept(IVisitor visitor);
    public abstract void doSomething();
}
