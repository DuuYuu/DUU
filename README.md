# DBlog开发日志
😀 Author : DuuYuu

😭 F-Time : 2021/12/11

🥰 Type : 个人博客 

😛  Use  : 项目学习 [ Springboot + JPA  + Mybatis + pageHelper插件... ]

😀  IDE : IDEA + WebStorm

😮 已完成功能：

    1） ‘我’登录进后台
    2） 错误页面
    3） 后台-分类展示、增加删除修改分类
    4） 后台-标签展示、增加删除修改标签
    5） 后台-博客展示


😛 后端项目进度：

    1）21-12-10  ： 创建项目、配置文件、异常处理、日志配置
    2）21-12-11  ： 错误跳转错误页面、分析实体类关系、实体类创建（创建数据库表）、新增后台登录页面、新增后台首页、后台登录
    3）21-12-12  ： MD5加密、登录拦截、pageHelper插件实现分页、分类页面展示、实现“添加删除增加更新”分类的接口
    4）21-12-13  ： JPA完成标签管理页、实现“添加删除增加更新”标签的接口、后台展示博客、新增博客的接口、查询博客（Mabatis动态查询+模糊查询）


😂 后续欲优化：

    1）界面调整优化
    2）前端提取公共部分
    3）细节处理
    4）代码整理



😁  异常整理：

    1）java.lang.IllegalStateException: Failed to load ApplicationContext  	at org.springframework.test.con....

        √解决：各种百度，最后不知道怎么突然间就好了，呵呵……（我是傻x）
        
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
