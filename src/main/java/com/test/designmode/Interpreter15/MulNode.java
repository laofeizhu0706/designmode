package com.test.designmode.Interpreter15;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class MulNode extends SymbolNode {
    public MulNode(INode left, INode rigth) {
        super(left, rigth);
    }

    @Override
    public int interpret() {
        return super.getLeft().interpret()*super.getRight().interpret();
    }
}
