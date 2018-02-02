package com.doubibobo.domain;

/**
 * http返回的最外层对象
 * Created by zhuch on 2018/2/2.
 */
public class Result<T> {
//    错误码
    private Integer code;

//    提示信息
    private String message;

//    具体的内容
    private T data;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
