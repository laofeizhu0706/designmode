package com.test.designmode.bridge9;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public abstract class AbstractionService {
    private Implementor implementor;

    public AbstractionService(Implementor implementor) {
        this.implementor = implementor;
    }

    /**
     * 其他操作
     */
    public abstract void otherOperation();

    /**
     * 操作
     */
    public void operation() {
        implementor.operationImpl();
    }
}
