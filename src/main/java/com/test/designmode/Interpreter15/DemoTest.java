package com.test.designmode.Interpreter15;

import org.junit.Test;

import java.util.Calendar;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class DemoTest {
    /**
     * 解释器模式测试
     */
    @Test
    public void InterpreterTest() {
        Calculator calculator=new Calculator();
        calculator.build("2*4/2%2");
        int result = calculator.getResult();
        System.out.println(result);
    }
}
