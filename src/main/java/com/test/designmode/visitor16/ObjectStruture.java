package com.test.designmode.visitor16;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class ObjectStruture {
    public List<Element> getList() {
        List<Element> list = new ArrayList<Element>();
        Random ran = new Random();
        for(int i=0; i<10; i++){
            int a = ran.nextInt(100);
            if(a>50){
                list.add(new ConcreteElement1());
            }else{
                list.add(new ConcreteElement2());
            }
        }
        return list;
    }
}
