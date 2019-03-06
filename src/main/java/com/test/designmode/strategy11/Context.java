package com.test.designmode.strategy11;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
class Context {
    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.doSomething();
    }
}

