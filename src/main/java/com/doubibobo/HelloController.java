package com.doubibobo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhuch on 2018/1/31.
 * 明确如何进行映射
 */
@RestController
public class HelloController {
    private String welcome = "Hello, Spring Boot";

    @Autowired
    private UserProperties userProperties;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return welcome;
    }

    @RequestMapping(value = {"/config", "/theconfig"}, method = RequestMethod.GET)
//    @RequestMapping(value = "/config", method = RequestMethod.GET)
//    public String config(@PathVariable("id") Integer id) {
    public String config(@RequestParam("id") Integer id) {

//        return userProperties.getName();
        return "id:" + id;
    }
}
