package com.test.designmode.builder4;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
@Data
public class Computer extends Device {
    private String cpu;
    private String mem;

    public Computer(String name, BigDecimal price, String cpu, String mem) {
        super(name, price);
        this.cpu = cpu;
        this.mem = mem;
    }
}
