package service;

import pojo.User;

import java.util.List;

/**
 * 功能
 *
 * @author caojianbang
 * @date 27.8.22 11:50 PM
 */
public interface UserService {
    //增删改分
    List<User> selectUserPage(String userName,String userSex,int startRow);
    int createUser(User user);
    int deleteUserById(String userId);
    int getRowCount(String unseName,String userSex);
}
