package com.test.designmode.singleton1;

/**
 * @author 老肥猪
 * @since 2019/3/1
 * msg: 懒汉模式
 */
public class LazySingleton {
    private static LazySingleton singleton;
    public static synchronized LazySingleton getInstance(){
        if(singleton==null){
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
