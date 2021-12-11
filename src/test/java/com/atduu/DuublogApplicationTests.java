package com.atduu;

import com.atduu.pojo.User;
import com.atduu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DuublogApplicationTests {

    //注入数据源
    @Autowired
    UserService userService;


    /*-------------mapper-------------*/



    /*---------service--------------*/
    @Test
    public void user(){

        User duuyuu = userService.checkUser("duuyuu", "123");

        System.out.println(duuyuu);

    }

}
