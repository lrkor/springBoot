package com.spring.inter.demo.service;

import com.spring.inter.demo.bean.User;

import java.util.List;

/**
 * @author lrkor
 * @Description
 * @date 2019/9/11 11:42
 **/
public interface IUserService {
    //获取所有的用户
    List<User> query();
    //增
    int add(User user);
    //删
    int  delete(long id);
    //改
    int update(User User);
    //查
    User get(long id);
}
