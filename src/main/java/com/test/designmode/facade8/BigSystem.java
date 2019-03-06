package com.test.designmode.facade8;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class BigSystem {
    public void menthod() {
        new SubSystem1().menthod();
        new SubSystem2().menthod();
        new SubSystem3().menthod();
    }
}
