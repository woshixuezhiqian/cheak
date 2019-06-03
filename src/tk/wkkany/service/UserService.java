package tk.wkkany.service;

import tk.wkkany.domain.User;

import java.util.List;
import java.util.Map;


/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User> findAll();

    /**
     * 登录方法
     *
     * @param user
     * @return
     */
    User login(User user);
        /*
        * 保存对象
        * */
    void addUser(User user);
/*根据id删除*/
    void deleteUser(String id);
/*
* 根据id查询
* */
    User findUserById(String id);
/*
* 修改
* */
    void updateUser(User user);


}