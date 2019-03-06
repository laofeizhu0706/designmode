package com.test.designmode.Intermediary20;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public abstract class AbstractColleague {
    protected int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public abstract void setNumber(int number, AbstractMediator am);
}
