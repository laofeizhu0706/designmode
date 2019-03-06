package com.test.designmode.memo18;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class Memento {
    private String state = "";
    public Memento(String state){
        this.state = state;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}
