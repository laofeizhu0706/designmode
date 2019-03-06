package com.test.designmode.flyweight21;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class ConcreteFlyweight implements Flyweight {

    private Character intrinsicState = null;
    /**
     * 构造函数，内蕴状态作为参数传入
     * @param state
     */
    public ConcreteFlyweight(Character state){
        this.intrinsicState = state;
    }
    /**
     * 外蕴状态作为参数传入方法中，改变方法的行为，
     * 但是并不改变对象的内蕴状态。
     */
    @Override
    public void operation(String state) {
        System.out.println("内蕴 = " + this.intrinsicState);
        System.out.println("外蕴 = " + state);
    }
}
