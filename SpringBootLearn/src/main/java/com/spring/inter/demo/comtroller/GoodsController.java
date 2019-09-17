package com.spring.inter.demo.comtroller;

import com.spring.inter.demo.bean.Goods;
import com.spring.inter.demo.rusult.ResultModel;
import com.spring.inter.demo.rusult.ResultModelTool;
import com.spring.inter.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lrkor
 * @Description
 * @date 2019/9/11 13:42
 **/
@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @PostMapping(value = "/query")
    public ResultModel query() {
        List<Goods> goodsList = goodsService.query();
        Map<String, List<Goods>> GoodsMap = new HashMap<>();
        if (GoodsMap != null) {
            GoodsMap.put("goods", goodsList);
        }
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(0);
        resultModel.setData(GoodsMap);
        return ResultModelTool.handleResultModel(resultModel);
    }

    @PostMapping(value = "/add")
    public ResultModel add(@RequestParam String name, @RequestParam Long price, @RequestParam String imgUrl, @RequestParam String isOften, @RequestParam String type) {
        Goods goods = new Goods(name, price, imgUrl, isOften, type);
        int errorCode = goodsService.add(goods);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(errorCode);
        resultModel.setData(goods);
        return ResultModelTool.handleResultModel(resultModel);
    }

    @PostMapping(value = "/update")
    public ResultModel update(@RequestParam long id, @RequestParam(value = "name", required = false,defaultValue = "") String name, @RequestParam(value = "price", required = false,defaultValue = "0") Long price, @RequestParam(value = "imgUrl", required = false,defaultValue = "") String imgUrl, @RequestParam(value = "isOften", required = false,defaultValue = "") String isOften, @RequestParam(value = "type", required = false,defaultValue = "") String type) {
        Goods goods = new Goods(id, name, price, imgUrl, isOften, type);
        int errorCode = goodsService.update(goods);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(errorCode);
        resultModel.setData(goods);
        return ResultModelTool.handleResultModel(resultModel);
    }

    @GetMapping(value = "/get")
    public ResultModel get(@RequestParam long id) {
        Goods goods = goodsService.get(id);
        ResultModel resultModel = new ResultModel();
        resultModel.setData(goods);
        return ResultModelTool.handleResultModel(resultModel);
    }

    @GetMapping(value = "/delete")
    public ResultModel delete(@RequestParam long id) {
        int errorCode = goodsService.delete(id);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(errorCode);
        List<Goods> goodsList = goodsService.query();
        Map<String, List<Goods>> GoodsMap = new HashMap<>();
        if (goodsList != null) {
            GoodsMap.put("goods", goodsList);
        }
        resultModel.setData(GoodsMap);
        return ResultModelTool.handleResultModel(resultModel);
    }
}
