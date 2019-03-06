package com.test.designmode.proxy7;

/**
 * @author 老肥猪
 * @since 2019/3/2
 */
public class UserPoxyService implements UserService {

    private UserService userServiceImpl;

    public UserPoxyService(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public void queryUserList() {
        userServiceImpl.queryUserList();
        System.out.println("新需求");
    }
}
