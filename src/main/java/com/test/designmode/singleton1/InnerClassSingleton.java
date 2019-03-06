package com.test.designmode.singleton1;

/**
 * @author 老肥猪
 * @since 2019/3/1
 * msg: 内部类实现单例
 */
public class InnerClassSingleton {
    public static class SingletonHolder {
        private static final InnerClassSingleton INSTANCE=new InnerClassSingleton();
    }
    private InnerClassSingleton getSingleton() {
        return SingletonHolder.INSTANCE;
    }
}
