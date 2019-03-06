package com.test.designmode.composite10;

import lombok.Data;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
@Data
public abstract class FolderComponent {
    private String name;

    public FolderComponent(String name) {
        this.name = name;
    }

    public abstract void add(FolderComponent component);

    public abstract void remove(FolderComponent component);

    public abstract void display();
}
