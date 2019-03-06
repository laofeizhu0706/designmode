package com.test.designmode.Interpreter15;

/**
 * @author 老肥猪
 * @since 2019/3/2
 * 数字的节点，表示非终结表达式
 */
public class NumberNode implements INode {

    private int value;

    public NumberNode(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return this.value;
    }
}
