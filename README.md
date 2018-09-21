# InfoManager简单介绍
<<<<<<< HEAD

学习了接近半个月的 java web 的入门内容，包括 servlet、jsp、jstl标签等，于是便做了一个简单的 java web 项目，就是一个用户信息管理系统，包括了用户登录、注册、模糊查询、添加新用户、修改、删除等基本的内容。

=======
学习了接近半个月的 java web 的入门内容，包括 servlet、jsp、jstl标签等，于是便做了一个简单的 java web 项目，就是一个用户信息管理系统，包括了用户登录、注册、模糊查询、添加新用户、修改、删除等基本的内容。

------

>>>>>>> 上传图片
## 登录界面

![登录界面](C:\Users\14455\Desktop\login.png)

## 注册界面

![注册界面](C:\Users\14455\Desktop\register.png)

## 主界面

![主界面](C:\Users\14455\Desktop\manage.png)

## 修改用户信息

![修改](C:\Users\14455\Desktop\update.png)



# 关于项目

1. 使用到的 jar 包

   - c3p0-0.9.5.2.jar

   - common-dbutils-1.6.jar

   - mchange-commons-java-0.2.11.jar

   - mysql-connector-java-5.0.8-bin.jar

   - servlet-api.jar

   - taglibs-standard-impl-1.2.5.jar

   - taglibs-standard-spec-1.2.5.jar

     

2. 自己创建的包名

   - dao ：实现与数据库的之间的访问
   - service ：实现与dao层的联系
   - model ：创建了一个User类
   - controller ：servlet所在的包
   - filter ：根据用户登录与否来过滤各个页面
   - utils ：创建数据库的连接和关闭

------

大家如果有好的建议欢迎提出修改，觉得不错就给个star吧！
