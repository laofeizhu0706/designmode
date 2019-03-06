package com.test.designmode.factory2.common;

/**
 * @author 老肥猪
 * @since 2019/3/2
 * msg:
 */
public class Bike implements Car {
    @Override
    public void gotowork() {
        System.out.println("Go to work by bike!");
    }
}