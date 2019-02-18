
# Hibernate 笔记

Hibernate是一个开放源代码的对象关系映射框架,它对JDBC进行了非常轻量级的对象封装,它将POJO与数据库表建立映射关系,是一个全自动的orm框架,
hibernate可以自动生成SQL语句,自动执行,使得Java程序员可以随心所欲的使用对象编程思维来操纵数据库.

**Hibernate工作原理**
1. 读取并解析配置文件;
2. 读取并解析映射信息,创建SessionFactory;
3. 打开Sesssion;
4. 创建事务Transation;
5. 持久化操作;
6. 提交事务;
7. 关闭Session;
8. 关闭SesstionFactory;
![Image text](https://github.com/995942712/notes/blob/master/img/Hibernate工作原理1.png)
![Image text](https://github.com/995942712/notes/blob/master/img/Hibernate工作原理2.png)


























