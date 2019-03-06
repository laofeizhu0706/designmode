package com.test.designmode.decorator6;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class OldPeople implements People {

    /**
     * 老人只要吃饭
     */
    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}
