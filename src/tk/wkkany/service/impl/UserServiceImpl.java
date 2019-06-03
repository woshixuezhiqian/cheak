package tk.wkkany.service.impl;
import tk.wkkany.dao.UserDao;
import tk.wkkany.dao.impl.UserDaoImpl;
import tk.wkkany.domain.User;
import tk.wkkany.service.UserService;

import java.util.List;

public class   UserServiceImpl implements  UserService{
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }
    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
