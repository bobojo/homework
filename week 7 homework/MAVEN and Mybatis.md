## MAVEN

#### Maven简介

Maven的本质是一个项目管理工具，将项目开发和管理过程抽象成一个项目对象模型(POM)
POM (Project Object Model)：项目对象模型

Maven的作用：

1. 项目构建：提供标准的、跨平台的自动化项目构建方式
2. 依赖管理：方便快捷的管理项目依赖的资源（jar包），避免资源间的版本冲突问题
3. 统一开发结构：提供标准的、统一的项目结构

#### Maven基础概念

仓库：用于存储资源，包含各种jar包
仓库分类：本地仓库和远程仓库（私服和中央仓库）

坐标：Maven中的坐标用于描述仓库中资源的位置
坐标的主要组成：
groupId：定义当前Maven项目隶属组织名称（通常是域名反写）
artifactId：定义当前Maven项目名称（通常是模块名称）
version：定义当前版本号
packaging：定义该项目的打包方式
坐标的作用：使用唯一的标识，唯一性定位资源位置，通过该标识可以将资源的识别与下载交由机器完成。

##### 1.环境变量配置

##### 2.建立自己的仓库坐标，仓库配置：

本地仓库配置：默认位置与自定义位置

1.新建文件夹maven->repository

2.进入maven->conf->setting.xml文件,找到<localRepository>修改路径。

##### 3.远程仓库配置（缓存慢）：

```
<repositories> 
  <repository>
		<id>central</id>
		<name>Central Repository</name> 
        <url>https://repo.maven.apache.org/maven2</url> 
        <layout>default</layout>
		<snapshots>
			<enabled>false</enabled> 
        </snapshots>
	</repository> 
</repositories>

```

##### 4.镜像仓库配置：

```
<mirrors>
	<mirror>
    <!-- 此镜像的唯一标识符，用来区分不同的mirror元素 -->
		<id>nexus-aliyun</id>
    <!-- 对那种仓库进行镜像（就是替代哪种仓库）-->
		<mirrorOf>central</mirrorOf>
    <!-- 镜像名称 -->
		<name>Nexus aliyun</name>
    <!-- 镜像URL -->
		<url>http://maven.aliyun.com/nexus/content/groups/public</url>
	</mirror> 
</mirrors>
```

#### 创建Maven项目

首先是maven项目的结构project->src->main/test->java/resources

Maven项目构建命令
Maven构建命令使用mvn开头，后面加功能参数，可以一次执行多个命令，使用空格分隔

```
mvn compile #编译
mvn clean #清理
mvn test #测试
mvn package	#打包
mvn install #安装到本地仓库
```

##### IDEA生产Maven项目

首先是配置Maven包，具体步骤视频。

然后就是修改pom.xml配置文件

###### 依赖管理

1.依赖配置

依赖指的是当前项目运行所需要的jar，一个项目可以设置多个依赖

格式：

```
<!--设置当前项目所依赖的所有jar-->
<dependencies>
  <!--设置具体的依赖-->
  <dependency>
    <!--依赖所属群组id-->
    <groupId></groupId>
    <!--依赖所属项目id-->
    <artifactId></artifactId>
    <!--依赖版本号-->
    <version></version>
  </dependency>
</dependencies>
```

2.依赖传递

依赖具有传递性，包括直接传递和间接传递。
直接传递：在当前项目中通过依赖配置建立的依赖关系（A使用B，A和B就是直接传递）
间接传递：被依赖的资源如果依赖其他资源，当前项目间接依赖其他资源（比较拗口，意思是如果A依赖B，而B依赖C，那么A和C之间就是间接传递）

依赖传递的冲突问题：路径优先：当依赖中出现相同的资源时，层级越深，优先级越低，层级越浅，优先级越高
声明优先：当资源在相同层级被依赖时，配置顺序靠前的覆盖配置顺序靠后的
特殊优先：当同级配置了相同资源的不同版本，后配置的覆盖先配置的
3.可选依赖

可选依赖指的是对外隐藏当前所依赖的资源

```
<dependency>
  <groupId></groupId>
  <artifactId></artifactId>
  <version></version>
  <!--添加下面这一行-->
  <optional>true</optional>
</dependency>
```

4.排除依赖

排除依赖指主动断开依赖的资源，被排除的资源无需指定版本

```
<dependency>
  <groupId></groupId>
  <artifactId></artifactId>
  <version></version>
  <exclusions>
    <exclusion>
      <groupId></groupId>
      <artifactId></artifactId>
    </exclusion>
  </exclusions>
</dependency>
```

5.依赖范围

依赖的jar包默认情况可以在任何地方使用，可以通过scope标签设定其作用范围
作用范围：
主程序范围有效（main文件夹范围内）
测试程序范围有效（test文件夹范围内）
是否参与打包（package文件夹范围内）

## Mybatis

#### MyBatis概述

 MyBatis是一款优秀的Java持久层框架，它封装了JDBC，使开发者只需要关注Sql语句本身，二不需要花费精力去处理加载驱动，创建连接、创建Statement等繁杂的过程

 MyBatis通过xml或注解的方式将要执行的各种statement配置起来，并通过java对象和statement中sql的动态参数进行映射生成最终执行的sql语句，最后由MyBatis框架执行sql并将结果映射为java对象并返回。

 采用ORM思想解决了实体和数据库映射的问题，对JDBC进行了封装，屏蔽了JDBC API底层访问细节，是我们不用与JDBC API打交道，就可以完成对数据库的持久化操作。

#### 环境搭建

1.创建maven工程并导入坐标，即在pom.xml中添加依赖（包括mybatis，mysql，log4j，junit)

2.创建数据库表以及对应的Java实体类

3.创建dao接口

4.创建MyBatis的主配置文件（SqlMapConfig.xml)

5.创建映射配置文件（IUserDao.xml）

注意事项：
 1.在MyBatis中，dao常被成为Mapper

 2.包与目录的创建方式不同：

 例如：com.maven.dao以packege方式创建是三级目录，以目录方式创建是一级目录。

 3.MyBatis的映射文件和Dao接口的包结构必须相同。（即IUserDao.xml与IUserDao.java的包结构必须相同）

4.映射配置文件的mapper的namespace属性必须是dao接口的全限定类名

5.映射配置文件的操作配置id属性必须是dao接口的方法名

6.每一个xml配置文件都要注册

```
    <mappers>
        <mapper resource="com/maven/dao/AccountMapper.xml"/>
    </mappers>
```

7.要是配置文件有效，需要添加映射

```
    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>
```

[我的作业代码仓库](https://github.com/bobojo/homework)

