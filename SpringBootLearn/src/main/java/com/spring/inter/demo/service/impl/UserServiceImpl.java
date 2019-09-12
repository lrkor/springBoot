package com.spring.inter.demo.service.impl;

import com.spring.inter.demo.bean.User;
import com.spring.inter.demo.repository.JpaUserRepository;
import com.spring.inter.demo.rusult.ErrorCode;
import com.spring.inter.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lrkor
 * @Description
 * @date 2019/9/11 11:46
 **/


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    JpaUserRepository jpaUserRepository;

    @Override
    public List<User> query() {
        List<User> users = jpaUserRepository.findAll();
        System.out.println(users.toString());
        return users;
    }

    @Override
    public int add(User user) {
        if (jpaUserRepository.existsById(user.getId())){
            System.out.println("user  is existed");
            return ErrorCode.EXISTUSER;
        }
        User saveUser = jpaUserRepository.save(user);
        if (saveUser != null && saveUser.getId() == user.getId()) {
            System.out.println("save success");
            return ErrorCode.ADDSUCCESS;
        } else {
            System.out.println("save failure");
            return ErrorCode.ADDFAIL;
        }
    }

    @Override
    public int delete(long id) {
        if (jpaUserRepository.existsById(id)) {
            jpaUserRepository.deleteById(id);
            System.out.println("删除成功");
            return ErrorCode.DELETESUCCESS;
        }
        System.out.println("删除失败");
        return ErrorCode.NOTEXISTUSER;
    }

    @Override
    public int update(User user) {
        if (jpaUserRepository.existsById(user.getId())){
            jpaUserRepository.save(user);
            System.out.println("更新成功");
            return ErrorCode.UPDATESUCCESS;
        }
        System.out.println("更新失败");
        return ErrorCode.UPDATEFAIL;
    }

    @Override
    public User get(long id) {
        User user = null;
        if (jpaUserRepository.existsById(id)){
            user = jpaUserRepository.findById(id).get();
            System.out.println(user);
        }
        return user;
    }
}


