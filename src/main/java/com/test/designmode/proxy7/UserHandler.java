package com.test.designmode.proxy7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class UserHandler implements InvocationHandler {
    private UserService userServiceImpl;

    public UserHandler(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj=null;
        if(method.getName().equals("queryUserList")) {
            System.out.println("新业务");
            obj=method.invoke(userServiceImpl,args);
        }
        return obj;
    }
}
