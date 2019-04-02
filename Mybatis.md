
# Mybatis 笔记

#### mybatis简介
mybatis是一个优秀的基于java的持久层框架,它内部封装了jdbc,使开发者只需要关注sql语句本身,而不需要花费精力去处理加载驱动,创建连接,创建statement等繁杂的过程;
mybatis通过xml或注解的方式将要执行的各种statement配置起来,并通过java对象和statement中sql的动态参数进行映射生成最终执行的sql语句,最后由mybatis框架执行sql并将结果映射为java对象并返回;
MyBatis支持定制化SQL,存储过程以及高级映射,MyBatis避免了几乎所有的JDBC代码和手动设置参数以及获取结果集,MyBatis可以使用简单的XML或注解来配置和映射原生信息,将接口和Java的POJO映射成数据库中的记录;

[官网](http://blog.mybatis.org)
[中文文档](http://www.mybatis.org/mybatis-3/zh/index.html)

#### Mybatis分层
1. API接口层:提供给外部使用的接口API.
2. 数据处理层:负责具体的SQL.
3. 基础支撑层:负责最基础的功能支撑,如连接管理,事务管理,配置加载和缓存处理.
#### mybatis工作流程
1. 创建SqlSessionFactoryBuilder.
2. 通过SqlsesionFactoryBuilder创建sqlSessionFactory.
3. 通过SqlSessionFactory创建sqlSession.
4. 通过sqlSession执行数据库操作.
5. 调用session.commit()提交事务.
6. 调用session.close()关闭会话.
#### Mybait的优点
1. 简单易学,容易上手(相比于Hibernate)基于SQL编程.
2. JDBC相比,减少了50%以上的代码量,消除了JDBC大量冗余的代码,不需要手动开关连接.
3. 很好的与各种数据库兼容(因为MyBatis使用JDBC来连接数据库,所以只要JDBC支持的数据库MyBatis都支持,而JDBC提供了可扩展性,所以只要这个数据库有针对Java的jar包就可以就可以与MyBatis兼容),开发人员不需要考虑数据库的差异性.
4. 提供了很多第三方插件(分页插件/逆向工程).
5. 能够与Spring很好的集成.
6. MyBatis相当灵活,不会对应用程序或者数据库的现有设计强加任何影响,SQL写在XML里,从程序代码中彻底分离,解除sql与程序代码的耦合,便于统一管理和优化,并可重用.
7. 提供XML标签,支持编写动态SQL语句.
8. 提供映射标签,支持对象与数据库的ORM字段关系映射.
9. 提供对象关系映射标签,支持对象关系组建维护.
#### MyBatis的缺点：
1. SQL语句的编写工作量较大,尤其是字段多,关联表多时,更是如此,对开发人员编写SQL语句的功底有一定要求.
2. SQL语句依赖于数据库,导致数据库移植性差,不能随意更换数据库.
#### MyBatis框架适用场合
1. MyBatis专注于SQL本身,是一个足够灵活的DAO层解决方案.
2. 对性能的要求很高,或者需求变化较多的项目,如互联网项目,MyBatis将是不错的选择.

#### Mybatis防止SQL注入
1. #{}：相当于JDBC中的PreparedStatement
2. ${}：是输出变量的值

























































