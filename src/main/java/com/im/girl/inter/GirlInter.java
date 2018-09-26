package com.im.girl.inter;

import com.im.girl.bean.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlInter extends JpaRepository<Girl, Integer> {

    //根据name查询
    List<Girl> findByName(String name);
}
