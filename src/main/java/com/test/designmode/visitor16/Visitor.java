package com.test.designmode.visitor16;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class Visitor implements IVisitor {

    @Override
    public void visit(ConcreteElement1 element1) {
        element1.doSomething();
    }

    @Override
    public void visit(ConcreteElement2 element2) {
        element2.doSomething();
    }
}
