package com.test.designmode.Iterator14;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public interface Aggregate<T> {
    void add(T obj);
    void remove(T obj);
    Iterator<T> iterator();
}
