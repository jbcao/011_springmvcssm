import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.User;
import service.UserService;

import java.util.List;

/**
 * 功能
 *
 * @author caojianbang
 * @date 28.8.22 11:18 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)//该注解用于启动Spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_service.xml","classpath:applicationContext_mapper.xml"})
public class Test {
    @Autowired
    UserService userService;
    @org.junit.Test
    public void selectUserPage(){
        List<User>  list =userService.selectUserPage("三","男",0);
        list.forEach(user -> System.out.println(user));
    }
    @org.junit.Test
    public void createUser(){
        User user = new User("199510065030","id","320723199510065030","cjb","man","27","tech" );
        int num = userService.createUser(user);
        System.out.println(num);
    }
    @org.junit.Test
    public void deleteUserById(){
        int num = userService.deleteUserById("199510065030");
        System.out.println(num);
    }
    @org.junit.Test
    public void getRowCount(){
        int num = userService.getRowCount(null,null);
        System.out.println(num);
    }
}
