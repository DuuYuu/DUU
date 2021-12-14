package com.atduu.dao;

import com.atduu.pojo.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created  by DuuYuu on 2021/12/13 15:53
 **/
public interface BlogDao extends JpaRepository<Blog ,Long>, JpaSpecificationExecutor<Blog> {


}
