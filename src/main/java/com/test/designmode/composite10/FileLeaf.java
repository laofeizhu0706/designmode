package com.test.designmode.composite10;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class FileLeaf extends FolderComponent {

    public FileLeaf(String name) {
        super(name);
    }

    @Override
    public void add(FolderComponent component) {

    }

    @Override
    public void remove(FolderComponent component) {

    }

    @Override
    public void display() {
        System.out.println("File name is "+this.getName());
    }
}
