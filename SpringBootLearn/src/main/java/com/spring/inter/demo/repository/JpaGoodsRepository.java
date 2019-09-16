package com.spring.inter.demo.repository;

import com.spring.inter.demo.bean.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lrkor
 * @Description
 * @date 2019/9/11 11:41
 **/
public interface JpaGoodsRepository extends JpaRepository<Goods,Long> {
}
