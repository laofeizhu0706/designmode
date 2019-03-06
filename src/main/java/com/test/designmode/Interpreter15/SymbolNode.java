package com.test.designmode.Interpreter15;

import lombok.Getter;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
@Getter
public abstract class SymbolNode implements INode {
    private INode left;
    private INode right;

    public SymbolNode(INode left, INode right) {
        this.left = left;
        this.right = right;
    }
}
