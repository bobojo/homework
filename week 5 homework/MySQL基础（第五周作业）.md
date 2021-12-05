#### **Navicat for MySQL 使用基础与 SQL 语言的DDL**

##### 1.建表

CREATE TABLE 表名字

(column1 datatype [DEFAULT expression], 

column1 datatype [DEFAULT expression], 

 ……）

建立表主要指定义下列信息：

列定义、主键定义、键定义、索引定义 、完整性约束、外键定义、表达式

检查

##### 2.更改表

增加一列：

alter table 表名 add (行名 数据类型() 约束性条件 default ' ' )

修改一列：

alter table 表名 MODIFY (行名 数据类型() 约束性条件 default ' ' )

删除一列：

alter table 表名 drop 行名

删除表：

drop table 表名

##### 3.建视图

create view 视图名（列名....）

as

select (查询语句，查询结果列对应视图列名)

删除视图

drop view 视图名

##### 4.建立索引

create index 索引名 on 表名 (对应列 asc|desc)

删除索引

drop index 索引名 on 表名

#### **SQL语言数据操纵语言DML**

##### 1.插入表信息

insert into 表名  ([属性列],[属性列]....)  values([常量],[常量]......)

##### 2.更新表

update 表名 set 更新语句 where 判断条件

delete   from  表名  where 判断条件

#### **SQL 语言数据查询语言 DQL**

##### 1.一般查询

select 要查询的列（可以有函数max,min,sum,avg等或者四则运算）

from 表名

where 查询条件

group by

having

##### 2.多表查询

select 表1.列,表2.列......

from 表1,表2......

where 表1.某列=表2.某列............

##### 3.exists查询

select .........

from 表名 x

where exists(

   select ......

   from 表名 y

   where ........

)

##### 4.嵌套查询

##### 5.组合查询

###### 注意事项

1、对表指定别名后，在 where 条件中要引用表名时，应引用别名。 

2、对于空值，只能用 is null 或 not is null 进行比较，而不能用=比较。

例： select \* from sc where grade is null

3、在作 like 进行模糊查询时，注意%和_的区别，同时要注意汉字所占用字节。 

4、having 只能用在 group by 子句后面，不能用在 where 子名后面。 

5、自身连接必须为表取别名。 

6、在连接查询中，如果一个字段来源于两个及两个以上的表，需要指明字段的来源，即需加上表名前缀，格式为“表名.字段名”。

7、在嵌套查询中，order by 只能用于最外层嵌套。 

8、内外层相关查询中，应对表取别名。 

[我的仓库链接]([github.com](https://github.com/bobojo/homework))

https://github.com/bobojo/homework