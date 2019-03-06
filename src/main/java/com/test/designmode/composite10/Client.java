package com.test.designmode.composite10;

import org.junit.Test;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class Client {

    @Test
    public void componentTest() {
        FolderComponent leaf = new FileLeaf("8PM.mp3");
        leaf.display();

        FolderComponent folder = new FolderComposite("电影");
        folder.add(new FileLeaf("疯狂的外星人"));
        folder.add(new FileLeaf("飞驰人生"));
        folder.display();
    }

}
