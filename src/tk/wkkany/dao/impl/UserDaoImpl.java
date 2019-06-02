package tk.wkkany.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import tk.wkkany.dao.UserDao;
import tk.wkkany.domain.User;
import tk.wkkany.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库...
        //1.定义sql
        String sql = "select * from user";
        List<User> users =  template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }
}
