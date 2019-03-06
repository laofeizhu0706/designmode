package com.test.designmode.chain19;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class Level {
    private int level = 0;
    public Level(int level){
        this.level = level;
    }

    public boolean above(Level level){
        if(this.level >= level.level){
            return true;
        }
        return false;
    }

}
