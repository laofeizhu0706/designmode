package com.test.designmode.chain19;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class ConcreteHandler2 extends Handler {
    protected Level getHandlerLevel() {
        return new Level(3);
    }

    public Response response(Request request) {
        System.out.println("-----请求由处理器2进行处理-----");
        return null;
    }
}
