package com.yutao.shi.test;

import com.yutao.shi.pojo.User;
import com.yutao.shi.service.UserService;
import com.yutao.shi.service.impl.UserserviceImpl;
import org.junit.Test;

/**
 * @author shiyutao
 * @create 2021-10-15 15:45
 */
public class UserserviceImplTest {
     UserService userService=new UserserviceImpl();
    @Test
    public void registUser() {
    userService.registUser(new User(null,"songfangyun","songfangyun1122","songfangyun@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "shiyutao", "shiyutao1116", null)));
    }

    @Test
    public void exitsUsername() {
        if(userService.exitsUsername("shiyutao1")){
            System.out.println("用户名已存在");

        }else
            System.out.println("用户名可用");
    }
}