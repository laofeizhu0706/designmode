package com.test.designmode.proxy7;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class DemoTest {

    /**
     * 静态代理
     */
    @Test
    public void staticProxy() {
        UserService userServiceImpl=new UserServiceImpl();
        UserService userPoxyService = new UserPoxyService(userServiceImpl);
        userPoxyService.queryUserList();
    }

    @Test
    public void dynamicProxy() {
        UserService userServiceImpl=new UserServiceImpl();
        UserHandler userServiceHandler=new UserHandler(userServiceImpl);
        UserService userService = (UserService) Proxy
                .newProxyInstance(ClassLoader.getSystemClassLoader(),
                        new Class[]{UserService.class},
                        userServiceHandler);
        userService.queryUserList();
    }
}
