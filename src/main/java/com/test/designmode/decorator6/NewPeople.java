package com.test.designmode.decorator6;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class NewPeople implements People {

    private People people;

    public NewPeople(People people) {
        this.people = people;
    }

    @Override
    public void eat() {
        System.out.println("做饭");
        people.eat();
        System.out.println("洗碗");
    }
}
