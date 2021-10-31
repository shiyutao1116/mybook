package com.yutao.shi.dao;

import com.yutao.shi.pojo.User;

/**
 * @author shiyutao
 * @create 2021-10-15 13:47
 */
public interface UserDAO {
public User querybyUsername(String username);
public int saveUser(User user);
public User querybyUsernameandpassword(String username,String password);


}
