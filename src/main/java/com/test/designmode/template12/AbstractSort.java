package com.test.designmode.template12;

import java.util.Arrays;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public abstract class AbstractSort {
    public abstract void sort(int[] arrs);

    /**
     * 打印数组
     * @param arrs
     */
    public void printSortArrary(int[] arrs) {
        this.sort(arrs);
        System.out.println(Arrays.toString(arrs));
    }

}
