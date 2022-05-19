package com.atduu.service.impl;

import com.atduu.NotFoundException;
import com.atduu.dao.TypeDao;
import com.atduu.pojo.Type;
import com.atduu.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created  by DuuYuu on 2021/12/12 16:13
 **/
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeDao typeDao;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeDao.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public  List<Type> selectAll(){
        return typeDao.findAll();
    }

    @Transactional
    @Override
    public Page<Type> findAllTypesByPages(Pageable pageable){
        return typeDao.findAll(pageable);
    }


    @Transactional
    @Override
    public Type updateType(Long id, Type type) {

        Type t = getType(id);

        if(t == null){
            throw new NotFoundException("不存在该分类");
        }

        BeanUtils.copyProperties(type, t );

        return typeDao.save(t);

    }

    @Transactional
    @Override
    public Boolean isExist(String name) {

        Type type = typeDao.findByName(name);

        if( type != null ){
            return true;
        }else {
            return false;
        }

    }

    @Transactional
    @Override
    public void deleteType(Long id) {

        typeDao.deleteById(id);

    }

    @Transactional
    @Override
    public List<Type> listTypeTop(Integer size) {

        Sort sort =  Sort.by(Sort.Direction.DESC,"blogs.size");

        Pageable pageable =  PageRequest.of(0, size, sort);

        return typeDao.findTop(pageable);
    }
}
