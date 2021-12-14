# DBlog开发日志
😀 Author : DuuYuu

😭 F-Time : 2021/12/11

🥰 Type : 个人博客

😛  Use  : 项目学习 [ Springboot + JPA  + ....~~Mybatis + pageHelper插件...~~ ]

😀  IDE : IDEA + WebStorm

😮 已完成功能：

    1） ‘我’登录进后台
    2） 错误页面
    3） 后台-分类分页展示、增加删除修改分类
    4） 后台-标签分页展示、增加删除修改标签
    5） 后台-博客分页展示、增加删除修改博客


😛 后端项目进度：

    1）21-12-10  ： 创建项目、配置文件、异常处理、日志配置
    2）21-12-11  ： 错误跳转错误页面、分析实体类关系、实体类创建（创建数据库表）、新增后台登录页面、新增后台首页、后台登录
    3）21-12-12  ： MD5加密、登录拦截、pageHelper插件实现分页、分类页面展示、实现“添加删除增加更新”分类的接口
    4）21-12-13  ： JPA完成标签管理页、实现“添加删除增加更新”标签的接口、后台展示博客、新增博客的接口、查询博客（Mabatis动态查询+模糊查询）
    5）21-12-14  ： 代码重构，去除Mybatis；实现增加修改删除博客，后台管理部分暂告段落，开始进入前端；实现前端分页展示接口；“分类”带条件展示；“标签”带标签暂时


😂 后续欲优化：

    1）界面优化
    2）前端提取公共部分
    3）细节处理
    4）代码整理
    5）删除数据后返回当前页


😁  重大异常整理：

    1）java.lang.IllegalStateException: Failed to load ApplicationContext  	at org.springframework.test.con....

        √解决：（我是傻x）
        
            也许是加了下面这个依赖的原因？？？？？？？
            <dependency>
                        <groupId>com.sun.xml.bind</groupId>
                        <artifactId>jaxb-core</artifactId>
                        <version>2.3.0</version>
            </dependency>

    2) 使用pagehelper后sql语句报错：

        √解决：mapper.xml中写的sql语句，不加 ; 分号


🤣 😄 😅 😆 😉 😋 😎 😍 😘 🥰

😗 L-Time : ...
