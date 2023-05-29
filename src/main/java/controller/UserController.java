package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;
import service.UserService;

import java.util.List;

/**
 * 功能
 *
 * @author caojianbang
 * @date 29.8.22 1:44 PM
 */
@CrossOrigin      //服务器端支持跨域访问
@RestController   //如果本类中全都是ajax请求，则使用此注解，方法上的@ResponseBody可不写
@RequestMapping("/user")
public class UserController {
    //多处使用的固定值，做成常量
    public static final Integer PAGE_SIZE = 5;

    @Autowired
    UserService userService;


    @RequestMapping("/selectUserPage")
    public List<User> selectUserPage(String userName,String userSex,Integer page) {
        List<User> list;
        System.out.println("selectUserPage()函数执行。。。");
        int startRow=0;
        //参与运算前要进行判空
        if(page!=null){
            startRow=(page - 1)*PAGE_SIZE;
        }
        list=userService.selectUserPage(userName,userSex,startRow);
        return list;
    }

    @RequestMapping("/getRowCount")
    public int getRowCount(String userName,String userSex) {
        return userService.getRowCount(userName,userSex);
    }

    @RequestMapping("/deleteUserById")
    public int deleteUserById(String userId) {
        return userService.deleteUserById(userId);
    }

    @RequestMapping("/createUser")
    public int createUser(User user) {
        /**
         * 手工创建主键方式
         *   1.uuid
         *   2.毫秒时间戳
         *   3.两个随机数拼接
         */
        String userId = System.currentTimeMillis()+"";
        user.setUserId(userId);
        return userService.createUser(user);
    }
}
