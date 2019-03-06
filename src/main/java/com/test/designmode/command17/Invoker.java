package com.test.designmode.command17;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class Invoker {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void action(){
        this.command.execute();
    }
}
