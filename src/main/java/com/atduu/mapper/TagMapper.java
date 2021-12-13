package com.atduu.mapper;

import com.atduu.pojo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created  by DuuYuu on 2021/12/12 16:14
 **/
public interface TagMapper extends JpaRepository<Tag ,Long> {

    Tag findByName(String name);

}
