package com.test.designmode.Intermediary20;

import org.junit.Test;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class TestDemo {
/**
 * 中介者模式（当互相影响的时候，可以使用）
 */
@Test
public void IntermediaryTest() {
    AbstractColleague collA = new ConcreteColleagueA();
    AbstractColleague collB = new ConcreteColleagueB();
    /**
     * 中间者，通过中间者去改变
     */
    AbstractMediator am = new ConcreteMediator(collA, collB);

    System.out.println("==========通过设置A影响B==========");
    collA.setNumber(1000, am);
    System.out.println("collA的number值为："+collA.getNumber());
    System.out.println("collB的number值为A的10倍："+collB.getNumber());

    System.out.println("==========通过设置B影响A==========");
    collB.setNumber(1000, am);
    System.out.println("collB的number值为："+collB.getNumber());
    System.out.println("collA的number值为B的0.1倍："+collA.getNumber());
}
}
