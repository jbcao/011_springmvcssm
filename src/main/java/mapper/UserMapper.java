package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

/**
 * 功能
 *
 * @author caojianbang
 * @date 27.8.22 4:30 PM
 */
public interface UserMapper {
/**
 * 根据条件分页获取分页数据	url	/user/selectUserPage?userName=z&userSex=男&page=null
 * 	参数
 * userName:表单中用户名称
 * userSex:表单中用户性别
 * page:提交的页码(第一次访问为null)
 * 	结果	有数据时：
 * [{
 * "userId":"15968954638794962",
 * "cardType":"身份证","
 * cardNo":"343343554654",
 * "userName":"撒撒旦",
 * "userSex":"女",
 * "userAge":"29",
 * "userRole":"生产、运输设备操作人员及有关人员"},
 * {….}
 * ]
 * 无数据时：
 * []
 */
List<User> selectUserPage(@Param("userName") String userName,
                          @Param("userSex") String userSex,
                          @Param("startRow") int startRow);//算好起始行的值
    /**
     * 增加用户	url	/user/createUser(参数见下面)
     * 	参数
     * cardType: this.ruleForm.cardType,//证件类型
     * cardNo: this.ruleForm.cardNo,//证件号码
     * userName: this.ruleForm.userName,//用户姓名
     * userSex: this.ruleForm.userSex,//用户性别
     * userAge: this.ruleForm.userAge,//用户年龄
     * userRole: this.ruleForm.userRole,//用户角色
     * 	结果	增加成功时：
     * 1
     * 增加失败时:
     * 0
     */
       int insert(User user);
    /**
     *根据用户ID删除用户	url	/user/ deleteUserById?userId= 15968162087363060
     * 	参数	userId:删除用户的id
     * 	结果	删除成功时：
     * 1
     * 删除失败时:
     * 0
     */
    int delete(String userId);
    /**
     * 获取总行数	url	/user/getRowCount?userName=z&userSex=男
     * 	参数
     * userName:表单中用户名称
     * userSex:表单中用户性别
     * 	结果	有数据时:
     * 12
     * 无数据时:
     * 0
     */
    int getRowCount(
            @Param("userName")
                    String userName,
            @Param("userSex")
                    String userSex);
}
