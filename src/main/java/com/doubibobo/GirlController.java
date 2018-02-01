package com.doubibobo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhuch on 2018/2/1.
 */
public class GirlController {

    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private DemoService demoService;

    @GetMapping(value = "/girls")
    public List<Demo> demoList() {
        return demoRepository.findAll();
    }

    /**
     *  添加一条记录
     * @param cupSize 罩杯
     * @param age 年龄
     * @return 返回添加的结果
     */
    @GetMapping(value = "/add")
    public Demo demoAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age) {
        Demo demo = new Demo();
        demo.setAge(age);
        demo.setCupSize(cupSize);
        return demoRepository.save(demo);
    }

    /**
     * 通过主键查询一个女生
     * @param id 主键
     * @return 查询结果
     */
    @GetMapping(value = "/findone/{id}")
    public Demo demoFindOne(@PathVariable("id") Integer id) {
        return demoRepository.findOne(id);
    }

    /**
     * 通过非主键来查询记录
     * @param age 主键
     * @return 查询结果
     */
    @GetMapping(value = "/find/age/{age}")
    public List<Demo> demoFindOneByAge(@PathVariable("age") Integer age) {
        return demoRepository.findByAge();
    }

    /**
     * 修改一条记录
     * @param id  主键
     * @param cupSize   罩杯
     * @param age   年龄
     */
    @PutMapping(value = "/updateone/{id}")
    public Demo demoUpdate(@PathVariable("id") Integer id,
                           @PathVariable("cupSize") String cupSize,
                           @PathVariable("age") Integer age) {
        Demo demo = new Demo();
        demo.setCupSize(cupSize);
        demo.setId(id);
        demo.setAge(age);
        return demoRepository.save(demo);
    }

    /**
     * 删除一条记录
     * @param id 主键
     */
    @DeleteMapping(value = "/deleteone")
    public void demoDelete(@PathVariable("id") Integer id) {
        demoRepository.delete(id);
    }

    @PostMapping(value = "/findInsertTwo")
    public void demoInsertTwo() {
        demoService.insertTwo();
    }
}
