package com.doubibobo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhuch on 2018/2/1.
 */
@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    public void insertTwo () {
        Demo demo1 = new Demo();
        Demo demo2 = new Demo();

        demo1.setAge(18);
        demo1.setCupSize("A");

        demo2.setAge(20);
        demo2.setCupSize("B");

        demoRepository.save(demo1);
        demoRepository.save(demo2);
    }
}
