package com.doubibobo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhuch on 2018/1/31.
 */
@Controller
public class DemoController {

    @RequestMapping(value = "/demo", method = RequestMethod.GET)

//    前后端完全实现了分离，不推荐使用模板
    public String demo() {
        return "index";
    }
}
