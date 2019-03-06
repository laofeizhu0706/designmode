package com.test.designmode.prototype3;

import lombok.Data;

/**
 * @author 老肥猪
 * @since 2019/3/2
 * msg: 发送邮件类
 */
@Data
public class Mail implements Cloneable {
    private String tail;
    private String receiver;
    private String subject;
    private String content;

    public Mail(Event event) {
        this.subject = event.getSubject();
        this.content = event.getContent();
    }

    @Override
    protected Mail clone() {
        Mail mail = null;
        try {
            mail = (Mail) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return mail;
    }

    public void sendMail() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Mail{" +
                "tail='" + tail + '\'' +
                ", receiver='" + receiver + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
