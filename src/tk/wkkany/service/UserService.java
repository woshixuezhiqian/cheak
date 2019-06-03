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

}