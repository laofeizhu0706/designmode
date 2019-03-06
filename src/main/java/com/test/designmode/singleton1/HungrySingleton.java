package com.test.designmode.singleton1;

/**
 * @author 老肥猪
 * @since 2019/3/1
 * msg: 饿汉模式
 */
public class HungrySingleton {
    private static final HungrySingleton singleton = new HungrySingleton();
    public static HungrySingleton getInstance(){
        return singleton;
    }
}
