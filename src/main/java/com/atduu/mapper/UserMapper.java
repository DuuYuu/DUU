package com.atduu.mapper;

import com.atduu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User findByUsernameAndPassword(String username, String password);

}
