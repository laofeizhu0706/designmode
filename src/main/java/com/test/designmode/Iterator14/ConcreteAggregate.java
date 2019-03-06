package com.test.designmode.Iterator14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class ConcreteAggregate<T> implements Aggregate<T> {
    private List<T> list=new ArrayList<>();

    @Override
    public void add(T obj) {
        list.add(obj);
    }

    @Override
    public void remove(T  obj) {
        list.remove(obj);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator<T>(list);
    }
}
