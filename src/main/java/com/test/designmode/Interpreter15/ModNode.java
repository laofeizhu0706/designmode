package com.test.designmode.Interpreter15;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class ModNode extends SymbolNode {
    public ModNode(INode left, INode right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return super.getLeft().interpret()%super.getRight().interpret();
    }
}
