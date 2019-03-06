package com.test.designmode.Interpreter15;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class DivNode extends SymbolNode {
    public DivNode(INode left, INode rigth) {
        super(left, rigth);
    }

    @Override
    public int interpret() {
        return super.getLeft().interpret()/super.getRight().interpret();
    }
}
