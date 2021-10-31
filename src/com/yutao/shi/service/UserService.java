package com.yutao.shi.service;

import com.yutao.shi.pojo.User;

/**
 * @author shiyutao
 * @create 2021-10-15 15:24
 */
public interface UserService {
public void registUser(User user);
public User login(User user);
public boolean exitsUsername(String username);
}
