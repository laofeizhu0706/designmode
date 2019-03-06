package com.test.designmode.Intermediary20;

import java.util.stream.Collectors;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class ConcreteColleagueA extends AbstractColleague {
    public void setNumber(int number, AbstractMediator am) {
        this.number = number;
        am.AaffectB();
    }
}
