package com.atduu.mapper;

import com.atduu.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created  by DuuYuu on 2021/12/12 16:14
 **/
@Mapper
@Repository
public interface TypeMapper {

    int save(Type type);

    Type findTypeById(Long id);

    int updateType(Type type);

    //查找所有
    List<Type> findAll();

    int deleteTypeById(Long id);

    Type findTypeByName(String name);
}
