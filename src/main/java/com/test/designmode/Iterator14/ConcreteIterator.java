package com.test.designmode.Iterator14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class ConcreteIterator<T> implements Iterator<T> {
    private List<T> list;

    private  int cursor=0;
    public ConcreteIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasHash() {
        if(cursor==list.size()) {
            return false;
        }
        return true;
    }

    @Override
    public T next() {
        T obj=null;
        if(this.hasHash()) {
            obj=this.list.get(cursor++);
        }
        return obj;
    }
}
