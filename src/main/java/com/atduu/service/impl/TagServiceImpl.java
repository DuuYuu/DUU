package com.atduu.service.impl;

import com.atduu.NotFoundException;
import com.atduu.dao.TagDao;
import com.atduu.pojo.Tag;
import com.atduu.service.TagService;
import com.atduu.util.MyUtils;
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
public class TagServiceImpl implements TagService {

    @Autowired
    TagDao tagMapper;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagMapper.save(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return  tagMapper.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public  List<Tag> selectAll(){
        return tagMapper.findAll();
    }

    @Transactional
    @Override
    public List<Tag> listTag(String ids) {

        List<Long> listId = MyUtils.convertToList(ids);

        return tagMapper.findAllById(listId);

    }

    @Transactional
    @Override
    public Page<Tag> findAllTagsByPages(Pageable pageable){
        return tagMapper.findAll(pageable);
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {

        Tag t = getTag(id);

        if(t == null){
            throw new NotFoundException("不存在该分类");
        }

        BeanUtils.copyProperties(t, tag );

        return tagMapper.save(t);
    }

    @Transactional
    @Override
    public Boolean isExist(String name) {

        Tag tag = tagMapper.findByName(name);

        if( tag != null ){
            return true;
        }else {
            return false;
        }

    }

    @Transactional
    @Override
    public void deleteTag(Long id) {

         tagMapper.deleteById(id);

    }

    @Override
    public List<Tag> listTagTop(Integer size) {

        Sort sort = Sort.by(Sort.Direction.DESC , "blogs.size");

        Pageable pageable = PageRequest.of(0, size, sort);

        return tagMapper.findTop(pageable);
    }
}
