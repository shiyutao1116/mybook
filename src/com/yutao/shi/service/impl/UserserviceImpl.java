package com.yutao.shi.service.impl;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yutao.shi.dao.UserDAO;
import com.yutao.shi.dao.impl.UserDAOImpl;
import com.yutao.shi.pojo.User;
import com.yutao.shi.service.UserService;

/**
 * @author shiyutao
 * @create 2021-10-15 15:31
 */
public class UserserviceImpl implements UserService {
    private UserDAO userDAO=new UserDAOImpl();

    @Override
    public void registUser(User user) {
            userDAO.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDAO.querybyUsernameandpassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean exitsUsername(String username) {
        if(userDAO.querybyUsername(username)==null){
  return false;


        }
        return true;
    }
}
