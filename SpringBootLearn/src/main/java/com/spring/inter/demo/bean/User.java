package com.spring.inter.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lrkor
 * @Description
 * @date 2019/9/11 11:36
 **/
@Entity
@Table(name="user")
public class User {
    @Id
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="user_name")
    private String userName;

    @Column(name="password")
    private String password;

    public User(){}

    public User(long id){
        this.id = id;
    }

    public User(String name){
        this.name = name;
    }

    public User(long id,String name){
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
