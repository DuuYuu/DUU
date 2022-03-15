# 🥶**个人网站日志记录**

🎈简介：基于SpringBoot的个人文章网站。

网站结构【新增对文章进行加锁和置顶、音乐列表播放的功能，下图未画出】：

![首页](E:\学习笔记\TyporaAssets\首页-16456191082231.png)

#### 🎉**技术组合：**

- 后端：Spring Boot + JPA（Hibernate） + thymeleaf模板
- 数据库：MySQL
- 前端UI：Semantic UI框架
- 服务器：腾讯云

##### 🎋**1、Semantic UI开发前端，SpringBoot开发后端**

创建SpringBoot项目勾选依赖：devtools、web、mysql、jpa、thymeleaf

##### **🎄2、工具与环境：**

- IDEA
- webStorm 【前期使用】
- vscode 【后期使用】
- Maven 3
- JDK 8
- Axure RP 8 （页面原型设计工具）
- Photoshop 【Ui布局设计】

##### 🎇**4、视频学习地址**

网址：https://www.bilibili.com/video/BV1nE411r7TF?p=45

##### 🎆**5、页面设计与开发**

###### 5.1 设计

**页面规划：**

- 前端展示：首页、详情页、分类、标签、归档、关于我、文章加密页面
- 后台管理：文章管理，分类管理，标签管理
- 错误页面：404 , 500 , error

###### 5.2 页面开发

Semantic UI官网  https://semantic-ui.com/

Semantic UI中文官网

WebStorm下载与破解

背景图片资源：https://www.pexels.com/zh-cn/

###### 5.3 插件集成

编辑器 Markdown   https://pandao.github.io/editor.md/

内容排版 typo.css  https://github.com/sofish/typo.css

动画 animate.css  https://animate.style/

滚动侦测 waypoints   http://imakewebthings.com/waypoints/

平滑滚动 jquery.scrollTo   https://github.com/flesler/jquery.scrollTo

音乐播放插件Aplayer：https://aplayer.js.org/#/home

动态背景插件particles.js：https://marcbruederlin.github.io/particles.js/#documentation



本项目并没有使用到的如下：

代码高亮 prism   https://github.com/PrismJS/prism

目录生成 Tocbot   https://tscanlin.github.io/tocbot/

二维码生成 qrcode.js   https://davidshimjs.github.io/qrcodejs/



#### ✨个人网站系统的用户故事：

角色：**普通访客**，**管理员（我）**

 ```
 - 访客，可以分页查看所有的文章
 - 访客，可以查看所有的分类
 - 访客，可以查看某个分类下的文章列表
 - 访客，可以查看所有的标签
 - 访客，可以查看某个标签下的文章列表
 - 访客，可以根据年度时间线查看文章列表
 - 访客，可以快速查看最新的推荐博客（暂未使用在主页面）
 - 访客，可以用关键字全局搜索文章
 - 访客，可以查看单个文章内容
 - 访客，可以对文章内容进行评论
 - 访客，可以看到置顶文章
 - 我，可以用户名和密码登录后台管理
 - 我，可以管理博客
   - 我，可以发布新文章
   - 我，可以对文章进行分类
   - 我，可以对文章打标签
   - 我，可以对文章添加密码（已完成）
   - 我，可以对文章置顶（已完成）
   - 我，可以修改文章
   - 我，可以删除文章
   - 我，可以根据标题，分类，标签查询文章
 - 我，可以管理文章分类
   - 我，可以新增一个分类
   - 我，可以修改一个分类
   - 我，可以删除一个分类
   - 我，可以根据分类名称查询分类
 - 我，可以管理文章标签
   - 我，可以新增一个标签
   - 我，可以修改一个标签
   - 我，可以删除一个标签
   - 我，可以根据名称查询标签
 ```



#### 🎏命名约定:（暂未使用此约定）

**Service/DAO层命名约定：**

 ```
 - 获取单个对象的方法用get做前缀。
 - 获取多个对象的方法用list做前缀。
 - 获取统计值的方法用count做前缀。
 - 插入的方法用save(推荐)或insert做前缀。
 - 删除的方法用remove(推荐)或delete做前缀。
 - 修改的方法用update做前缀。
 ```



#### 🎃开发日志:

##### Duu开发日志

😀 Author : DuuYuu

😭 F-Time : 2021/12/11

😃 U-Time: 2022/03/04

😗 L-Time : ...

🥰 Type : 个人文章网站

😛 Use  : 项目学习 [ Springboot + JPA  +  ....~~Mybatis + pageHelper插件...~~ ]

😀 IDE : IDEA + WebStorm + VScode

😄 学习地址 : https://www.bilibili.com/video/BV1nE411r7TF?p=42

😮 已完成功能：

    1） ‘我’登录进后台
    2） 错误页面
    3） 后台-分类分页展示、增加删除修改分类
    4） 后台-标签分页展示、增加删除修改标签
    6） 后台-文章分页展示、增加删除修改文章
    7） 前台-首页文章带条件分页展示
    8） 文章详情
    9） 文章搜索
    10）评论展示
    11）關於我頁面（网站进入所显示的页面）
    12）可对文章进行加密（开发完成） 
    13）可对文章进行置顶（开发完成） 
    14) 新增音乐列表（关于我页面 下滑自动播放音乐）
    15）“关于我”界面美化


😛 后端项目进度：

``` 
1）21-12-10  ： 创建项目、配置文件、异常处理、日志配置
2）21-12-11  ： 错误跳转错误页面、分析实体类关系、实体类创建（创建数据库表）、新增后台登录页面、新增后台首页、后台登录
3）21-12-12  ： MD5加密、登录拦截、pageHelper插件实现分页、分类页面展示、实现“添加删除增加更新”分类的接口
4）21-12-13  ： JPA完成标签管理页、实现“添加删除增加更新”标签的接口、后台展示文章、新增文章的接口、查询文章（Mabatis动态查询+模糊查询）
5）21-12-14  ： 代码重构，去除Mybatis,去除pageHelper插件；实现增加修改删除文章；后台管理部分暂告段落，开始进入前端；实现前端分页展示接口；“分类”带条件展示；“标签”展示
6）21-12-15  ： 首页文章分页展示、类别展示、标签展示、点击文章进入详情页面
7）21-12-18  ： 实现评论功能、评论（父评论和子评论）展示
8）21-12-19  ： 實現關於我界面、博客基本部分基本完成
9）22-02-01  ： 前端界面大更新，去除首页的标签、分类、推荐文章的显示，去除最新文章的显示；界面更加简洁化，动态化，美观化。（耗时5+天）
10）22-02-23 ： 优化“错误界面”
11) 22-02-24 ： 整理前端代码；开始开发文章加密功能；修改数据库字段；修改前端提交表单的页面；新增点击加锁的文章弹出表单提交密码；
12）22-02-25 ：整理后端代码；新增回答枷锁文章的问题的页面；完成了对文章进行加锁的功能（点击加锁的文章跳转到回答问题的界面，答案错误返回当前页并给出提示，答案错误跳转文章详情界面；点击未加锁的文章直接跳转到文章详情界面）；对网站进行初步测试；解决了“修改标签失效”的bug；优化文章首图显示的尺寸；购买了腾讯云服务器，连接了宝塔，申请了域名；
13）22-02-26 : 制作并设置网站logo图标；注册域名；新增文章置顶功能；优化“回答问题页面”的“文字”比“背景图片”显示快的问题；等待三天后的网站备案；
14）22-02-27 :  整理js代码；优化左侧的侧边栏；新增“打赏我”；优化错误界面；“关于我”界面插入音乐列表（但由于浏览器限制，不能实现自动播放）；等待两天后的网站备案；
15）22-03-02 ： 提交网站备案；重构“关于我界面”，使用jquery.scrollTo，平滑滑动页面；
16）22-03-03 ： 完成重构“关于我界面”（使用Photoshop和高漫画板自绘网页图片）；点击下滑图标自动播放音乐;修复首页的置顶文章bug;优化首页（第一页同非第一页布局不同）
17）22-03-04 ： 优化关于我界面，新增动态背景；修复搜索界面、分类、标签界面的bug；修复index（管理）页面的前端bug
```


🥰 后续需优化：

    1）界面大优化（√ 展示界面的美化已基本完成 22-2-1）
    2）去除thymeleaf模板【这个模板太TM麻烦了】（× 未完成）
    3）细节处理（√ 基本完成）
    4）代码整理（√ 基本完成）
    5）删除数据后返回当前页（× 后台管理，未完成）
    6）登录QQ进行评论（× 未完成）
    7）公共模板方法失效问题（√ 不使用公共模板）
    8) 搜索数据为0条时...（√ 完成）
    9）点击空白处侧边栏退回【取消这个需求】（× 未完成）
    10) 删除数据弹出确认窗口【可有可无】（× 未完成）
    11）网页标题栏图标（√ 完成）
    12）优化加载图片的速度问题（×）；
    13）左边侧边栏随着滚动条显示的位置出现（√）；
    14）播放音乐（√ 完成——由于浏览器限制不能实现自动播放）
    15）使用ajax技术刷新页面
    16）上下平滑滑动页面
    17）前端性能优化（learning...）


😁  重大异常整理【停止更新】：

    1）java.lang.IllegalStateException: Failed to load ApplicationContext   at org.springframework.test.con....
    
        √解决：
        
            也许是加了下面这个依赖的原因？？？？？？？
            <dependency>
                        <groupId>com.sun.xml.bind</groupId>
                        <artifactId>jaxb-core</artifactId>
                        <version>2.3.0</version>
            </dependency>
    
    2) 使用pagehelper后sql语句报错：
    
        √解决：mapper.xml中写的sql语句，不加 ; 分号



🤣 😄 😅 😆 😉 😋 😎 😍 😘 🥰







