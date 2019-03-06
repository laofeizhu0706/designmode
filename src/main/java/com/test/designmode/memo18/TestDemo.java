package com.test.designmode.memo18;

import org.junit.Test;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class TestDemo {

    /**
     * 备忘录模式(crtl + z原理)
     */
    @Test
    public void MemoTest() {
        Originator originator = new Originator();
        originator.setState("状态1");
        System.out.println("初始状态:"+originator.getState());
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());
        originator.setState("状态2");
        System.out.println("改变后状态:"+originator.getState());
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("恢复后状态:"+originator.getState());
    }
}
