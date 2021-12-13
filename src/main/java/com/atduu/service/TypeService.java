package com.atduu.service;

import com.atduu.pojo.Type;
import com.github.pagehelper.PageInfo;

import java.util.List;


/**
 * Created  by DuuYuu on 2021/12/12 16:11
 **/
public interface TypeService {

    int saveType(Type type);

    Type getType(Long id);

    List<Type> selectAll();

    PageInfo<Type> findAllTypesByPages( int pageNum , int pageSize);

    int updateType(Long id , Type type);

    Boolean isExist(String name);

    int deleteType(Long id);

}
