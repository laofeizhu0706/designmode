package com.test.designmode.observer13;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public abstract class AbstractSubject {
    public BlockingQueue<Observer> observers=new LinkedBlockingDeque<>();

    public void addObserver(Observer observer) {
        this.observers.offer(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    protected void updateObservers() {
        /**
         * 使用并行处理业务
         */
        observers.parallelStream().forEach(observer -> observer.update());
    }

    public abstract void doSomething();
}
