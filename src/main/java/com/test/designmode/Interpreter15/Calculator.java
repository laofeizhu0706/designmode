package com.test.designmode.Interpreter15;

import java.util.Stack;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class Calculator {
    private INode node;
    public void build(String statement) {
        INode left=null,right=null;
        char[] symbols = statement.trim().toCharArray();
        Stack<INode> stack = new Stack<>();
        for (int i = 0; i < symbols.length; i++) {
            String symbol = Character.toString(symbols[i]);
            if(symbol.equalsIgnoreCase("*")) {
                left=stack.pop();
                int val = Integer.parseInt(Character.toString(symbols[++i]));
                right = new NumberNode(val);
                stack.push(new MulNode(left,right));
            } else if(symbol.equalsIgnoreCase("/")) {
                left=stack.pop();
                int val = Integer.parseInt(Character.toString(symbols[++i]));
                right = new NumberNode(val);
                stack.push(new DivNode(left,right));
            } else if(symbol.equalsIgnoreCase("%")) {
                left=stack.pop();
                int val = Integer.parseInt(Character.toString(symbols[++i]));
                right = new NumberNode(val);
                stack.push(new ModNode(left,right));
            } else {
                stack.push(new NumberNode(Integer.parseInt(symbol)));
            }
        }
        this.node=stack.pop();
    }

    public int getResult() {
        return this.node.interpret();
    }
}
