package com.yutao.shi.dao.impl;

import com.yutao.shi.dao.UserDAO;
import com.yutao.shi.pojo.User;
import org.junit.Test;

/**
 * @author shiyutao
 * @create 2021-10-15 14:03
 */
public class UserDAOImpl extends BaseDAO implements UserDAO{


    @Override
    public User querybyUsername(String username) {
         String sql="select `id`,`username`,`password`,`email`from t_user where username=?";
        return searchone(User.class,sql,username);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User querybyUsernameandpassword(String username, String password) {
        String sql="select `id`,`username`,`password`,`email`from t_user where username=?and password=?";
        return searchone(User.class,sql,username,password);
    }

}
