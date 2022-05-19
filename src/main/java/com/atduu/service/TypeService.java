package com.atduu.service;

import com.atduu.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * Created  by DuuYuu on 2021/12/12 16:11
 **/
public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    List<Type> selectAll();

    Page<Type> findAllTypesByPages(Pageable pageable);

    Type updateType(Long id , Type type);

    Boolean isExist(String name);

    void deleteType(Long id);

    //获取首页展示的分类
    List<Type> listTypeTop(Integer size);

}
