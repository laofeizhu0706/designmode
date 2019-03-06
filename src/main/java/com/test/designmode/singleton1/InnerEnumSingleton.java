package com.test.designmode.singleton1;

/**
 * @author 老肥猪
 * @since 2019/3/1
 * msg: 内部枚举类实现单例
 */
public class InnerEnumSingleton {
    private enum SingletonHolder {
        INSTANCE;
        private InnerEnumSingleton singleton;
        SingletonHolder() {
            singleton=new InnerEnumSingleton();
        }
        public InnerEnumSingleton getSingleton() {
            return singleton;
        }
    }
    public InnerEnumSingleton getSingleton() {
        return SingletonHolder.INSTANCE.getSingleton();
    }
}
