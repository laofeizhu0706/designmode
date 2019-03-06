package com.test.designmode.memo18;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
