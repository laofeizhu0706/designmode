package com.test.designmode.Intermediary20;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public abstract class AbstractMediator {
    protected AbstractColleague A;
    protected AbstractColleague B;

    public AbstractMediator(AbstractColleague a, AbstractColleague b) {
        A = a;
        B = b;
    }

    public abstract void AaffectB();

    public abstract void BaffectA();
}
