
# Ftp 笔记

**Linux 下安装 ftp**

1.检查是否安装 ftp

`rpm –qa | grep vsftpd`

2.安装 ftp

`yum install vsftpd (有网)`

`rpm -ivh vsftpd-2.2.2-11.el6_4.1.x86_64.rpm (无网)`

3.添加 ftp 用户

添加用户

`useradd -d 目录路径 -g ftp -s /sbin/nologin 用户名`

设置密码

`passwd 用户名`

更改目录拥有者

`chown -R 用户名:ftp 目录路径`

赋予目录的权限

`chmod -R 775 目录路径`

4.配置vsftpd.conf

`vim /etc/vsftpd/vsftpd.conf`

`anonymous_enable=NO NO表示禁止匿名登录`

`local_enable=YES`

`write_enable=YES`

`local_umask=022`

`dirmessage_enable=YES`

`xferlog_enable=YES`

`connect_from_port_20=YES`

`chroot_local_user=YES`

`listen=YES`

`listen_ipv6=NO`

最后添加

`local_root=目录路径`

`user_config_dir=/etc/vsftpd/userconfig`

5.配置 userconfig

`cd /etc/vsftpd`

创建 userconfig 目录

`mkdir userconfig`

给userconfig目录赋权限

`chmod -R +X userconfig/`

创建用户的目录配置文件

`vim /etc/vsftpd/userconfig/[用户]`

在配置文件中增加一行

`local_root=[目录路径]`

启动命令

`service vsftpd start`

停止命令

`service vsftpd stop`

重启命令

`service vsftpd restart`

开启开机启动

`chkconfig vsftpd on`

取消开机启动

`chkconfig vsftpd off`

ftp 命令

`rpm -ivh ftp-0.17-54.el6.x86_64.rpm`

`ftp [IP地址]`

输入用户名和密码

`put [文件上传]`

`get [文件下载]`

查看当前目录情况

`ls`

显示当前路径

`pwd`







