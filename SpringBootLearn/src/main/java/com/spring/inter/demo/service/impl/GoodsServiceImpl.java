package com.spring.inter.demo.service.impl;

import com.spring.inter.demo.bean.Goods;
import com.spring.inter.demo.repository.JpaGoodsRepository;
import com.spring.inter.demo.rusult.ErrorCode;
import com.spring.inter.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lrkor
 * @Description
 * @date 2019/9/11 11:46
 **/


@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    JpaGoodsRepository jpaGoodsRepository;

    @Override
    public List<Goods> query() {
        List<Goods> goods = jpaGoodsRepository.findAll();
        System.out.println(goods.toString());
        return goods;
    }

    @Override
    public int add(Goods goods) {
        if (jpaGoodsRepository.existsById(goods.getId())){
            System.out.println("goods  is existed");
            return ErrorCode.EXISTUSER;
        }
        Goods saveGoods = jpaGoodsRepository.save(goods);
        if (saveGoods != null && saveGoods.getId() == goods.getId()) {
            System.out.println("save success");
            return ErrorCode.ADDSUCCESS;
        } else {
            System.out.println("save failure");
            return ErrorCode.ADDFAIL;
        }
    }

    @Override
    public int delete(long id) {
        if (jpaGoodsRepository.existsById(id)) {
            jpaGoodsRepository.deleteById(id);
            System.out.println("删除成功");
            return ErrorCode.DELETESUCCESS;
        }
        System.out.println("删除失败");
        return ErrorCode.NOTEXISTUSER;
    }

    @Override
    public int update(Goods goods) {
        if (jpaGoodsRepository.existsById(goods.getId())){
            jpaGoodsRepository.save(goods);
            System.out.println("更新成功");
            return ErrorCode.UPDATESUCCESS;
        }
        System.out.println("更新失败");
        return ErrorCode.UPDATEFAIL;
    }

    @Override
    public Goods get(long id) {
        Goods good = null;
        if (jpaGoodsRepository.existsById(id)){
            good = jpaGoodsRepository.findById(id).get();
            System.out.println(good);
        }
        return good;
    }
}


