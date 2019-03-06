package com.test.designmode.command17;

import org.junit.Test;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class TestDemo {

    /**
     * 测试命令模式
     */
    @Test
    public void testCommand() {
        ConcreteCommand command = new ConcreteCommand(new Receiver());
        command.execute();

        Invoker invoker=new Invoker();
        invoker.setCommand(command);
        invoker.action();
    }
}
