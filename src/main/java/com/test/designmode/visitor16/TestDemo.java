package com.test.designmode.visitor16;

import org.junit.Test;

import java.util.List;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class TestDemo {

    /**
     * 访问者模式测试
     */
    @Test
    public void visitorTest() {
        List<Element> list = new ObjectStruture().getList();
        for (Element element:
             list) {
            element.accept(new Visitor());
        }
    }
}
