# 说明

- app，app2 展示的是ORMLite 数据库的使用的使用
- greendaodemo，展示的是GreenDao3.2 数据库框架的基本使用
- greendaodemo2 展示的是GreenDao3.2 数据库框架的实战使用

### GreenDao数据库的使用大概步骤
1：在工程 bugild.gradle 进行如下插件配置
  classpath 'org.greenrobot:greendao-gradle-plugin:3.2.2' // add plugin

2：在module bugild.gradle 进行如下数据库框架的远程依赖：
  compile 'org.greenrobot:greendao:3.2.2' // add library
  
  apply plugin: 'org.greenrobot.greendao' // apply plugin
  //greendao配置
        greendao {
            //版本号，升级时可配置
            schemaVersion 1
            daoPackage 'com.example.greendaodemo.sql.dao'
            targetGenDir 'src/main/java'
        }
  
3:创建bean类。映射关系

4：创建好后， Build ---> Make Project 之后，greenDao插件会帮我自动创建好Dao层，相关的类。


#更多数据库详细说明访问下面的链接

【Android 数据库框架总结，总有一个适合你！】

https://blog.csdn.net/da_caoyuan/article/details/61414626


