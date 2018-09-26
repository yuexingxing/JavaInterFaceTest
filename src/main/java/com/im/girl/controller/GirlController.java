package com.im.girl.controller;

import com.im.girl.bean.Girl;
import com.im.girl.inter.GirlInter;
import com.im.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlInter girlInter;

    @Autowired
    GirlService girlService;

    @GetMapping(value = "/list")
    public List<Girl> getGirlList() {

        return girlInter.findAll();
    }

    @PostMapping(value = "/add")
    public Girl add(@RequestParam("name") String name, @RequestParam("age") String age) {

        Girl girl = new Girl();
        girl.setName(name);
        girl.setAge(age);

        return girlInter.save(girl);
    }

    //根据ID查询
    @GetMapping(value = "/girls/{id}")
    public Girl query(@PathVariable(value = "id") Integer id) {

        return girlInter.getOne(id);
    }

    //根据姓名查询
    //自定义接口
    @GetMapping(value = "/girls/find_by_name")
    public List<Girl> findByName(@RequestParam(value = "name") String name) {

        return girlInter.findByName(name);
    }

    //根据ID更新
    @PostMapping(value = "/update")
    public Girl update(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("age") String age) {

        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setName(name);

        boolean flag = girlInter.existsById(id);
        if (flag) {
            return girlInter.save(girl);
        } else {
            girl.setName("用户不存在");
            return girl;
        }
    }

    //根据ID删除
    @PostMapping(value = "/delete")
    public void update(@RequestParam("id") Integer id) {

        girlInter.deleteById(id);
    }

    @GetMapping(value = "/saveTwo")
    public void saveTwo(){

        girlService.saveTwo();
    }
}
