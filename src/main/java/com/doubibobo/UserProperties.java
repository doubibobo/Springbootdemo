package com.doubibobo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zhuch on 2018/1/31.
 * 解析配置文件中的内容
 */
@Component
@ConfigurationProperties(prefix = "theUser")
public class UserProperties {
    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
