
# Redis 笔记

**Linux 下安装 redis**

重启

`ps -ef|grep redis`

`kill 20940`

`bin/redis-server redis.conf`

远程连接

`./redis-cli -h 你服务器的ip -p 6379 -a 你的密码`

### Linux环境配置redis环境
```
在线安装
# wget http://download.redis.io/releases/redis-3.2.6.tar.gz
yum安装gcc依赖
# yum install gcc
# tar xzf redis-3.2.6.tar.gz
# cd redis-3.2.6
# make MALLOC=libc
# cd src
# make install

以后台进程方式启动redis
修改 redis/redis.conf文件
# vim redis.conf
daemonize no 修改为 daemonize yes

设置redis登陆密码
# requirepass foobared 去掉注释的#,把foobared改成密码

redis开机自启动
在/etc目录下新建redis目录
# mkdir redis
# cp redis/redis.conf /etc/redis/6379.conf
将redis的启动脚本复制一份放到/etc/init.d目录下
# cp redis/utils/redis_init_script /etc/init.d/redisd

切换到/etc/init.d目录下
# vim redisd
在第一行加入如下两行注释
# chkconfig: 2345 90 10
# description: Redis is a persistent key-value database

将Redis的命令所在目录添加到系统参数PATH中
# vim /etc/profile
# export PATH=$PATH:/usr/local/redis/bin
# source /etc/profile

重启系统
# reboot

启动redis
# service redisd start

关闭redis进程
# ps -aux | grep redis
# kill -9 进程号
```







