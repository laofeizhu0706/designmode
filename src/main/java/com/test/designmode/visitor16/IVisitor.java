package com.test.designmode.visitor16;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public interface IVisitor {
    void visit(ConcreteElement1 element1);
    void visit(ConcreteElement2 element2);
}
