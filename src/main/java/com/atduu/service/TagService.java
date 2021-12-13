package com.atduu.service;

import com.atduu.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * Created  by DuuYuu on 2021/12/12 16:11
 **/
public interface TagService {

    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    List<Tag> selectAll();

    List<Tag> listTag(String ids);

    Page<Tag> findAllTagsByPages(Pageable pageable);

    Tag updateTag(Long id , Tag tag);

    Boolean isExist(String name);

    void deleteTag(Long id);

}
