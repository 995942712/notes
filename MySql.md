




**linux下mysql数据的导出和导入**

**导出整个数据库中的所有数据**

`mysqldump -u userName -p  dabaseName  > fileName.sql`

导出数据库中的某个表的数据

`mysqldump -u userName -p  dabaseName tableName > fileName.sql`

导出整个数据库中的所有的表结构

`mysqldump -u userName -p -d dabaseName  > fileName.sql`

导出整个数据库中某个表的表结构

`mysqldump -u userName -p -d dabaseName tableName > fileName.sql`

导入mysql方法

`mysql -uroot -p database < fileName.sql`




















