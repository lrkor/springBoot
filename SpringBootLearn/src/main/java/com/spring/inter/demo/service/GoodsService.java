package com.spring.inter.demo.service;

import com.spring.inter.demo.bean.Goods;

import java.util.List;

/**
 * @author lrkor
 * @Description
 * @date 2019/9/11 11:42
 **/
public interface GoodsService {
    //获取所有的用户
    List<Goods> query();
    //增
    int add(Goods goods);
    //删
    int delete(long id);
    //改
    int update(Goods goods);
    //查
    Goods get(long id);
}
