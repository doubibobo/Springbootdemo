package com.doubibobo.controller;

import com.doubibobo.domain.Result;
import com.doubibobo.repository.DemoRepository;
import com.doubibobo.domain.Demo;
import com.doubibobo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import utils.ResultUtil;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by zhuch on 2018/2/1.
 */
@RestController
public class GirlController {

    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private DemoService demoService;

    /**
     * 查询所有的女生
     * @return 返回所有女生的json格式文件
     */
    @GetMapping(value = "/girls")
    public List<Demo> demoList() {
        return demoRepository.findAll();
    }

    /**
     *  添加一条记录
     * @return 返回添加的结果
     */
//    @PostMapping(value = "/add")
//    public Demo demoAdd(@RequestParam("cupSize") String cupSize,
//                        @RequestParam("age") Integer age) {
//        Demo demo = new Demo();
//        demo.setAge(age);
//        demo.setCupSize(cupSize);
//        return demoRepository.save(demo);
//    }
//  简洁的写法
    @PostMapping(value = "/add")
    public Result<Demo> demoAdd(@Valid Demo demo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage(), 1);
        }
        demo.setCupSize(demo.getCupSize());
        demo.setAge(demo.getAge());

        return ResultUtil.success(demoRepository.save(demo));
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
        return demoRepository.findByAge(age);
    }

    /**
     * 修改一条记录
     * @param id  主键
     * @param cupSize   罩杯
     * @param age   年龄
     */
    @PutMapping(value = "/update/{id}")
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
    @DeleteMapping(value = "/delete/{id}")
    public void demoDelete(@PathVariable("id") Integer id) {
        demoRepository.delete(id);
    }

    @RequestMapping(value = "/two", method = RequestMethod.GET)
    public void demoInsertTwo() {
        demoService.insertTwo();
//        return "this is two";
    }

    @GetMapping(value = "/age/find/{id}")
    public void getOneAge(@PathVariable("id") Integer id) throws Exception{
        demoService.getAgeById(id);
    }
}
