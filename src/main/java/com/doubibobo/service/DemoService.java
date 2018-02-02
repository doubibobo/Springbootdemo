package com.doubibobo.service;

import com.doubibobo.DemoException.DemoException;
import com.doubibobo.enums.ResultEnum;
import com.doubibobo.repository.DemoRepository;
import com.doubibobo.domain.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhuch on 2018/2/1.
 */
@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    // 标记这是一个事物，要成功此步骤全部成功，不成功则都不成功
    @Transactional
    public void insertTwo () {
        Demo demo1 = new Demo();
        Demo demo2 = new Demo();

        demo1.setAge(18);
        demo1.setCupSize("C");

        demo2.setAge(20);
        demo2.setCupSize("DDDD");

        demoRepository.save(demo1);
        demoRepository.save(demo2);
    }

    public void getAgeById (Integer id) throws Exception{
        Demo demo = demoRepository.findOne(id);
        if (demo.getAge() <= 18) {
            throw new DemoException(ResultEnum.PRIMARY_SCHOOL);
        }  else {
            throw new DemoException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
}
