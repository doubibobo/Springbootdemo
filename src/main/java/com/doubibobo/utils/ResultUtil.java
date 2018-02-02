package com.doubibobo.utils;

import com.doubibobo.domain.Result;

/**
 * 成功或者错误信息异常等的工具类
 * Created by zhuch on 2018/2/2.
 */
public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMessage("添加女生成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
            return success(null);
    }

    public static Result error(String msg, Integer code) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
}
