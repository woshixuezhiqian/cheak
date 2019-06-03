package tk.wkkany.dao;

import tk.wkkany.domain.User;

import java.util.List;

public interface UserDao {


    public List<User> findAll();

    User findUserByUsernameAndPassword(String username, String password);
}
