package com.test.designmode.Intermediary20;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class ConcreteMediator extends AbstractMediator {
    public ConcreteMediator(AbstractColleague a, AbstractColleague b) {
        super(a, b);
    }

    @Override
    public void AaffectB() {
        B.setNumber(A.getNumber()*100);
    }

    @Override
    public void BaffectA() {
        A.setNumber(B.getNumber()/100);
    }
}
