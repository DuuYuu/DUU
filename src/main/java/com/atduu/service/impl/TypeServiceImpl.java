package com.atduu.service.impl;

import com.atduu.NotFoundException;
import com.atduu.mapper.TypeMapper;
import com.atduu.pojo.Type;
import com.atduu.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created  by DuuYuu on 2021/12/12 16:13
 **/
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeMapper typeMapper;

    @Transactional
    @Override
    public int saveType(Type type) {
        return typeMapper.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeMapper.findTypeById(id);
    }

    @Transactional
    @Override
    public  List<Type> selectAll(){
        return typeMapper.findAll();
    }

    /**
     * 带分页信息查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Transactional
    @Override
    public PageInfo<Type> findAllTypesByPages(int pageNum , int pageSize){

        String orderBy = "id desc"; //根据id降序

        PageHelper.startPage(pageNum, pageSize,orderBy);

        List<Type> lists = typeMapper.findAll();

        return new PageInfo<Type>(lists);
    }


    @Transactional
    @Override
    public int updateType(Long id, Type type) {

        Type t = getType(id);

        if(t == null){
            throw new NotFoundException("不存在该分类");
        }

        return typeMapper.updateType(type);
    }

    @Transactional
    @Override
    public Boolean isExist(String name) {

        Type type = typeMapper.findTypeByName(name);

        if( type != null ){
            return true;
        }else {
            return false;
        }

    }

    @Transactional
    @Override
    public int deleteType(Long id) {

        return typeMapper.deleteTypeById(id);

    }
}
