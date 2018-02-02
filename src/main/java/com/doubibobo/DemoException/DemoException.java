package com.doubibobo.DemoException;

import com.doubibobo.enums.ResultEnum;

/**
 * Created by zhuch on 2018/2/2.
 */
public class DemoException extends RuntimeException{
    private Integer code;

    public DemoException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
