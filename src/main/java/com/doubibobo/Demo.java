package com.doubibobo;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by zhuch on 2018/2/1.
 * 对应一个实体表
 */
@Entity
public class Demo {
    @Id
    @GeneratedValue
    private Integer id;
    private String cupSize;
    private Integer age;

    public Demo() {

    }

    public Integer getId() {
        return id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
