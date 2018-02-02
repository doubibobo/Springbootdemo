package com.doubibobo.handle;

import com.doubibobo.DemoException.DemoException;
import com.doubibobo.domain.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.doubibobo.utils.ResultUtil;

/**
 * Created by zhuch on 2018/2/2.
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof DemoException) {
            DemoException demoException = (DemoException) e;
            return ResultUtil.error(demoException.getMessage(), demoException.getCode());
        } else {
            return ResultUtil.error("未知错误", -1);
        }
    }
}
