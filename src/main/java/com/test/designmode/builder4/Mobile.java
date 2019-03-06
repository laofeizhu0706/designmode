package com.test.designmode.builder4;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
@Data
public class Mobile extends Device {
    private String cpu;
    private String camera;

    public Mobile(String name, BigDecimal price, String cpu, String camera) {
        super(name, price);
        this.cpu = cpu;
        this.camera = camera;
    }
}