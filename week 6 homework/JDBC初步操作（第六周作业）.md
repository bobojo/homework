### **JDBC初步操作**

#### 1.JDBC

概念：Java DataBase Connectivity java数据库连接，java语言操作数据库

JDBC本质：其实就是官方（sun)公司定义的一套操作所有关系型数据库的规则，即接口。各个数据库厂商去实现这套接口，提供数据库驱动jar包。我们可以使用这套接口（JDBC)编程，真正执行的代码是驱动jar包中的实现类。

#### 2.快速入门

##### 1.导入驱动jar包

  1.复制mysql-connection-5.1.37-bin.jar到创建好的libs项目目录下面

  2.右键libs---->Add As library正真的把jar包加载进来

##### 2.注册驱动

##### 3.获取数据库连接对象 Connection

##### 4.定义sql语句

##### 5.获取执行sql语句的对象 statement

##### 6.执行sql,接受返回结果

##### 7.处理结果

##### 8.释放资源

#### 3.详解各个对象：

##### 1.DriverManager:驱动管理对象

  *功能：

​              1.注册驱动：就是面向对象编程里面告诉程序该运行哪个程序包

​               我们在代码上面看的是写的**Class.forName("com.mysql.jdbc.Driver")**

​               其实在这个类对应的函数里面也是有相同的方法叫做

​               static void registerDriver(Driver driver):注册与给定的驱动程序DriverManager

​               写代码使用的是Class.forName("com.mysql.jdbc.Driver")执行这个类，类里面有静态代码块      自动执行按两下shift键搜索Driver查看源码）

```
public class Driver extends NonRegisteringDriver implements java.sql.Driver {
public Driver() throws SQLException {}
static {
try {
     DriverManager.registerDriver(new Driver());
   } catch (SQLException var1) {
throw new RuntimeException("Can't register driver!");
   }}}
```

##### 2.获取数据库连接对象

方法：

```
public static Connection getConnection(String url,
                                       String user,
                                       String password)
```

参数：

*url:指定连接的路径

*语法：jdbc:mysql://ip地址（域名）：端口号/数据库名

*例子：jdbc:mysql://localhost:3306/student

*细节：如果连接的是本机mysql服务器且端口号为3306，可以省略为 jdbc:mysql:///数据库连接名 

##### 3.Connection:数据库连接对象

​    1.功能：

​         1.1获取执行sql的对象

​             *Statement createStatement()

​             *PreparedStatement prepareStatement(String sql)

​          1.2管理事务

​             *开启事务：setAutoCommit(boolean autoCommit):调用该方法设置参数为false

​             *提交事务：commit();

​             *回滚事务:   rollback();

##### 4.Statement:执行sql的对象

1.执行sql

​      1.1 boolean execute(String sql):可以执行任意的sql ,多用于处理相对复杂的sql语句

​      1.2 int executeUpdate(String sql)执行DML（insert update delete) DDL（create alert drop)语句

​            *返回值：影响的行数，可以通过这个影响的行数判断DML语句是否执行成功

​             executeQuery(String sql)执行(select)查询语句

##### 5.ResultSet:结果集对象,封装查询结果的  

​    *next() 游标向下移动一行

​    *getXXX(参数)获取数据

​    *XXX代表数据类型 如：int getInt(); String getString();

​    $参数：

​          1.int:代表列的编号，从1开始 如：getString(1);

​          2.String代表的是列的名称，如：getDouble("列名");

​    ***注意：**

​    *使用的步骤：

​            1.游标向下移动一行

​            2.判断是否有数据boolean next(),判断当前行是否是最后一行末尾（是否有数据），如果是，则返回false,如果不是则返回true.

​            3.获取数据

```
while(rs.next()){
    //6.2获取数据
    String sno=rs.getString(1);
    String name=rs.getString("Name");
    int age=rs.getInt(3);
    String college=rs.getString("College");
    System.out.println(sno+"---"+name+"---"+age+"---"+college);
}
```

##### ！！！[我的仓库](https://github.com/bobojo/homework)！！！

