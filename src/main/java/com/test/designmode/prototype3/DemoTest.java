package com.test.designmode.prototype3;

import org.junit.Test;

/**
 * @author 老肥猪
 * @since 2019/3/2
 * 原型测试模式的测试类
 */
public class DemoTest {
    @Test
    public void prototypeTest() {
        Event event=new Event("邀请信（变动参数）","张晓聪结婚了（不变参数）");
        Mail mail=new Mail(event);
        for (int i=0;i<9;i++) {
            Mail cloneMail = mail.clone();
            cloneMail.setTail("陈（变化参数）"+i);
            cloneMail.setReceiver("134243919"+i+"@qq.com");
            cloneMail.sendMail();
        }
    }
}
