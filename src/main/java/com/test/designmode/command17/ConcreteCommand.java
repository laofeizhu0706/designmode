package com.test.designmode.command17;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class ConcreteCommand implements Command {
    private Receiver receiver;
    public ConcreteCommand(Receiver receiver){
        this.receiver = receiver;
    }

    /**
     * 命令执行，让执行者去执行命令
     */
    @Override
    public void execute() {
        receiver.doSomething();
    }
}
