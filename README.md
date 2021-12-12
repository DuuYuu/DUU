# DBlog开发日志
😀 Author : DuuYuu

😭 F-Time : 2021/12/11

🥰 Type : 个人博客 

😛  Use  : 项目学习 [ Springboot + Mybatis + pageHelper插件... ]

😀  IDE : IDEA + WebStorm

😮 已完成功能：

    1） ‘我’登录进后台
    2） 错误页面
    3） 后台-分类展示、增加分类


😛 项目进度：

    1）21-12-10  ： 创建项目、配置文件、异常处理、日志配置
    2）21-12-11  ： 错误跳转错误页面、分析实体类关系、实体类创建（创建数据库表）、新增后台登录页面、新增后台首页、后台登录
    3）21-12-12  ： MD5加密、登录拦截、pageHelper插件实现分页、分类页面展示、实现“添加删除增加”分类接口
            



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

😂 后续欲优化：

    1）界面调整优化
   

🤣 😄 😅 😆 😉 😋 😎 😍 😘 🥰

😗 L-Time : ...
