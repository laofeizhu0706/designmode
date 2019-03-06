package com.test.designmode.composite10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class FolderComposite extends FolderComponent {
    private List<FolderComponent> components=new ArrayList<>();
    public FolderComposite(String name) {
        super(name);
    }

    @Override
    public void add(FolderComponent component) {
        components.add(component);
    }

    @Override
    public void remove(FolderComponent component) {
        components.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Folder name is " + this.getName());
        for (FolderComponent component:
        components) {
            System.out.println("File of "+this.getName()+"'Folder name is "+component.getName());
        }
    }
}
