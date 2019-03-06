package com.test.designmode.Intermediary20;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class ConcreteColleagueB extends AbstractColleague {
    public void setNumber(int number, AbstractMediator am) {
        this.number = number;
        am.BaffectA();
    }
}
