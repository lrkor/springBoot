package com.spring.inter.demo.rusult;

import java.io.Serializable;

/**
 * @author lrkor
 * @Description
 * @date 2019/9/11 11:48
 **/
public class ResultModel implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public ResultModel() {
    }

    public ResultModel(int errorCode, String msg, Object data) {
        this.code = errorCode;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
