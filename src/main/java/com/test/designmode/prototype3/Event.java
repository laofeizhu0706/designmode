package com.test.designmode.prototype3;

import lombok.Data;

/**
 * @author 老肥猪
 * @since 2019/3/2
 * msg: 不变事件信息
 */
@Data
public class Event {
    private String subject;
    private String content;

    public Event(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }
}
