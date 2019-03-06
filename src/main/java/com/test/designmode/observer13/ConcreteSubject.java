package com.test.designmode.observer13;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class ConcreteSubject extends AbstractSubject {
    @Override
    public void doSomething() {
        /**
         * 观察者被事件触发，处理各自业务，以及整体任务
         */
        System.out.println("其他业务");
        super.updateObservers();
    }
}
