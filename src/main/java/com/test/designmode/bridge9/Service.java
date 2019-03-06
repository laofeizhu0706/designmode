package com.test.designmode.bridge9;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class Service extends AbstractionService {
    public Service(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void otherOperation() {
        System.out.println("其他业务");
    }
}
