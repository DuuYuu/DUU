package com.atduu.dao;

import com.atduu.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created  by DuuYuu on 2021/12/13 15:53
 **/
public interface BlogDao extends JpaRepository<Blog ,Long>, JpaSpecificationExecutor<Blog> {

    @Query("select b from Blog b where b.recommend = true")
    List<Blog> findTop(Pageable pageable);

    @Query("select b from Blog  b where b.title like ?1 or b.content like ?1")
    Page<Blog> findByQuery(String query ,Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Blog b set b.views = b.views + 1 where b.id = ?1")
    int updateViews(Long id);

    @Query("select function('date_format' , b.createTime , '%Y')  from Blog b group by function('date_format' , b.createTime , '%Y')  order by function('date_format' , b.createTime , '%Y') desc ")
    List<String> findGroupYears();

    @Query("select  b from Blog b where function('date_format' , b.createTime , '%Y') = ?1 ")
    List<Blog> findByYear(String year);
}
