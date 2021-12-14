package com.atduu.dao;

import com.atduu.pojo.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created  by DuuYuu on 2021/12/12 16:14
 **/
public interface TagDao extends JpaRepository<Tag ,Long> {

    Tag findByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);

}
