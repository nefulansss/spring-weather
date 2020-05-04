package com.nefu.spring.weather.util;

import java.io.Serializable;

/**
 * @program: fast
 * @description: 返回类型
 * @author: nefulan
 * @create: 2019-11-15 16:53
 **/

public class JsonResult<T> implements Serializable {

    /**
     * 数据
     */
    private T data;
    /**
     * 信息
     */
    private String message;
    /**
     * 状态码
     */
    private int code;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public JsonResult(T data, String message, int code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public JsonResult(String message) {
        this.message = message;
        this.code = 101;
    }

    public JsonResult(T data) {
        this.data = data;
        this.code = 101;
    }
}
