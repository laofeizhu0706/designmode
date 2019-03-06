package com.test.designmode.template12;

import org.junit.Test;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class DemoTest {
    @Test
    public void templateTest() {
        int[] arrs=new int[]{1,5,4,3,2};
        AbstractSort sort=new ConcreteSort();
        sort.printSortArrary(arrs);
    }
}
