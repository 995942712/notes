
# Hibernate 笔记
#### 简介
Hibernate是一个开放源代码的对象关系映射框架,它对JDBC进行了非常轻量级的对象封装,它将POJO与数据库表建立映射关系,是一个全自动的orm框架,
hibernate可以自动生成SQL语句,自动执行,使得Java程序员可以随心所欲的使用对象编程思维来操纵数据库.

[官网](http://hibernate.org/orm)
[官方文档](https://docs.jboss.org/hibernate/stable/orm/userguide/html_single/Hibernate_User_Guide.html)

#### Hibernate工作原理
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

#### 延迟加载
延迟加载机制:通过设置属性lazy进行设置是否需要懒加载,当Hibernate在查询数据的时候,数据并没有存在与内存中,当程序真正对数据的操作时,对象才存在与内存中,就实现了延迟加载,他节省了服务器的内存开销,从而提高了服务器的性能.

#### hibernate缓存机制
**一级缓存**
1. hibernate支持两个级别的缓存,默认只支持一级缓存;
2. 每个Session内部自带一个一级缓存;
3. 某个Session被关闭时,其对应的一级缓存自动清除;

**二级缓存**
1. 二级缓存独立于session,默认不开启;

#### Jdbc,hibernate,ibatis的区别
**jdbc**
1. 手动手动写sql;
2. delete,insert,update要将对象的值一个一个取出传到sql中,不能直接传入一个对象;
3. select返回的是一个resultset,要从ResultSet中一行一行,一个字段一个字段的取出,然后封装到一个对象中,不直接返回一个对象.

**mybatis**
1. sql要手动写;
2. delete,insert,update直接传入一个对象;
3. select直接返回一个对象.

**hibernate**
1. 不写sql,自动封装;
2. delete,insert,update直接传入一个对象;
3. select直接返回一个对象.

#### 优化Hibernate
1. 使用双向一对多关联,不使用单向一对多.
2. 灵活使用单向一对多关联.
3. 不用一对一,用多对一取代.
4. 配置对象缓存,不使用集合缓存.
5. 一对多集合使用Bag,多对多集合使用Set.
6. 继承类使用显式多态.
7. 表字段要少,表关联不要怕多,有二级缓存撑腰.

#### Hibernate中get和load的区别
1. session.get():查询立即执行,返回Customer类对象.
2. session.load():默认采用延迟加载数据方式,不会立即查询,返回Customer类子类对象(动态生成代理对象).
3. 如果PO类使用final修饰,load无法创建代理对象,返回目标对象本身(load效果和get效果相同).

#### SQL和HQL的区别
1. sql:面向数据库表查询,from后面跟的是表名,where后用表中字段做条件.
2. hql:面向对象查询,from后面跟的类名＋类对象,where后用对象的属性做条件(常用).

#### Hibernate的分页查询
例如:从数据库中的第20000条数据开始查后面100条记录.
1. Query q = session.createQuery("from Cat as c");
2. q.setMaxResults(100);
3. List l = q.list();
4. q.setFirstResult(20000);

#### Hibernate三种状态
**编写规则** 
1. 必须提供无参数public构造器.
2. 所有属性private,提供public的getter和setter方法.
3. 必须提供标识属性,与数据表中主键对应,例如Customer类id属性.
4. PO类属性应尽量使用基本数据类型的包装类型(区分空值).
5. 不要用final修饰(将无法生成代理对象进行优化).

瞬时状态:不存在持久化标识OID,尚未与Session关联对象,被认为处于瞬时态,失去引用将被JVM回收.
持久状态:存在持久化标识OID,与当前session有关联,并且相关联的session没有关闭,并且事务未提交.
脱管状态:存在持久化标识OID,但没有与当前session关联,脱管状态改变hibernate不能检测到.

区分三种状态:判断对象是否有OID(即主键),判断对象是否与session关联(被一级缓存引用).
```
Session session =HibernateUtils.openSession();//获得Session
Transaction transaction = session.beginTransaction();//开启事务
Book book =newBook();//瞬时态(没有OID,未与Session关联)
book.setName("hibernate精通");
book.setPrice(56d);
session.save(book);//持久态(具有OID,与Session关联)
transaction.commit();//提交事务
session.close();//关闭Session
System.out.println(book.getId());//脱管态(具有OID,与Session断开关联)
```
**状态转换**
![Image text](https://github.com/995942712/notes/blob/master/img/Hibernate状态转换.jpg)
1. 瞬时态对象(通过new获得);瞬时==>持久:save,saveOrUpdate(都是session);瞬时==>脱管:book.setId(1)为瞬时对象设置OID.
2. 持久态对象(通过get/load,Query查询获得);持久==>瞬时:delete(被删除持久化对象,不建议再次使用);持久==>脱管:evict(清除一级缓存中某一个对象),close(关闭Session清除一级缓存),clear(清除一级缓存所有对象).
3. 脱管态对象(无法直接获得);脱管==>瞬时:book.setId(null);删除对象OID;脱管==>持久:update,saveOrUpdate,lock(过时).






