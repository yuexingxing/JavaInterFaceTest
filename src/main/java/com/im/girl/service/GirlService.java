package com.im.girl.service;

import com.im.girl.bean.Girl;
import com.im.girl.inter.GirlInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class GirlService {

    @Autowired
    GirlInter girlInter;

    //事务一致性
    @Transactional
    public void saveTwo(){

        Girl girlA = new Girl();
        girlA.setName("A");
        girlA.setAge("11");
        girlInter.save(girlA);

        Girl girlB = new Girl();
        girlB.setName("B");
        girlB.setAge("22");
        girlInter.save(girlB);
    }
}
