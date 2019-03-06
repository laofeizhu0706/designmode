package com.test.designmode.builder4;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
@Data
public class Device {
    private String name;
    private BigDecimal price;

    public Device(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
