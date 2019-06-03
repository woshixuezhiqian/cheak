package tk.wkkany.dao;

import tk.wkkany.domain.User;

import java.util.List;

public interface UserDao {


    public List<User> findAll();

    User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void delete(int id);

    User findById(int i);
    void  update(User user);
}
