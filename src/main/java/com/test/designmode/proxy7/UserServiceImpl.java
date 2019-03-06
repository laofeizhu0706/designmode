package com.test.designmode.proxy7;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class UserServiceImpl implements UserService{
    @Override
    public void queryUserList() {
        System.out.println("查询业务");
    }
}
