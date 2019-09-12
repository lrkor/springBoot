package com.spring.inter.demo.comtroller;

import com.spring.inter.demo.bean.User;
import com.spring.inter.demo.rusult.ResultModel;
import com.spring.inter.demo.rusult.ResultModelTool;
import com.spring.inter.demo.service.IUserService;
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
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping(value = "/query")
    public ResultModel query(){
        List<User> userList = userService.query();
        Map<String,List<User>> UserMap = new HashMap<>();
        if(UserMap!=null){
            UserMap.put("users",userList);
        }
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(0);
        resultModel.setData(UserMap);
        return ResultModelTool.handleResultModel(resultModel);
    }

    @PostMapping(value = "/add")
    public ResultModel add(@RequestParam String name){
        User User = new User(name);
        int errorCode = userService.add(User);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(errorCode);
        resultModel.setData(User);
        return ResultModelTool.handleResultModel(resultModel);
    }
    @PostMapping(value = "/update")
    public ResultModel update(@RequestParam long id,@RequestParam String name){
        User User = new User(id,name);
        int errorCode = userService.update(User);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(errorCode);
        resultModel.setData(User);
        return ResultModelTool.handleResultModel(resultModel);
    }
    @GetMapping(value = "/get")
    public ResultModel get(@RequestParam long id){
        System.out.println(id);
        User User = userService.get(id);
        ResultModel resultModel = new ResultModel();
        resultModel.setData(User);
        return ResultModelTool.handleResultModel(resultModel);
    }
    @GetMapping(value = "/delete")
    public ResultModel delete(@RequestParam long id){
        int errorCode = userService.delete(id);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(errorCode);
        List<User> userList = userService.query();
        Map<String,List<User>> UserMap = new HashMap<>();
        if (userList!=null){
            UserMap.put("users",userList);
        }
        resultModel.setData(UserMap);
        return ResultModelTool.handleResultModel(resultModel);
    }
}
