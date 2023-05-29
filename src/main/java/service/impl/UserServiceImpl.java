package service.impl;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;

import java.util.List;

/**
 * 功能
 *
 * @author caojianbang
 * @date 28.8.22 12:27 AM
 */
@Service
public class UserServiceImpl implements UserService {
    //切记：要有数据访问层对象
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> selectUserPage(String userName, String userSex, int startRow) {
        return userMapper.selectUserPage(userName,userSex,startRow);
    }

    @Override
    public int createUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteUserById(String userId) {
        return userMapper.delete(userId);
    }

    @Override
    public int getRowCount(String unseName, String userSex) {
        return userMapper.getRowCount(unseName,userSex);
    }
}
