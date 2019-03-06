package com.test.designmode.state22;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class Context {

    private State state;

    @Getter
    @Setter
    private BigDecimal bill;

    public void handle() {
        check();
        this.state.behavior();
    }

    private void check() {
        if(this.bill.compareTo(new BigDecimal(0))>0) {
            this.state=new ConcreteStateB();
        }else {
            this.state=new ConcreteStateA();
        }
    }
}
