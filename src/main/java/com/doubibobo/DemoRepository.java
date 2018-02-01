package com.doubibobo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhuch on 2018/2/1.
 */
public interface DemoRepository extends JpaRepository<Demo, Integer> {

    // 通过年龄来查询
    public List<Demo> findByAge();
}
