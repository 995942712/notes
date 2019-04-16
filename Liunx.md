
# Liunx 命令

[Liunx命令大全](https://www.linuxprobe.com)

**重启**
```
reboot
```

**关机**
```
shutdown -h now
```

**开启网络连接**
```
cd /etc/sysconfig/network-scripts/
把 ONBOOT 改为yes
vi ifcfg-eno
```

**重启服务**
```
service network restart
```

**ifconfig安装**

下载包:
```
yum install net-tools
```

**vim安装**
```
# rpm -qa|grep vim
# yum -y install vim*

查询 vi 和 vim 命令指向的程序
# cd ~
# which vi vim
编辑 bashrc 配置文件
# vim .bashrc
在 .bashrc 文件里增加一条命令指向后保存退出
alias vi='vim'
重启 bash,让刚才的配置生效
# source .bashrc
再次查询 vi 和 vim 的指向确认
# which vi vim
```

#### 目录管理
**切换目录**
```
cd [目录路径]
```
**创建目录**
```
mkdir 目录名
```
**删除目录**
```
rmdir 目录名
```
**查看文件列表**
```
ls [目录路径]
ll [目录路径]
ls -a [目录路径]
ll -h [目录路径]
```
**查看文件**
```
cat [文件名]
more [文件名]
less [文件名]
tail -n 行数 -f [文件名]
```
**创建文件**
```
touch 文件名
```
**复制文件**
```
cp 源文件路径 目标文件路径
```
**移动文件(重命名)**
```
mv 源文件路径 目标文件路径
mv 文件名 新文件名
```
**删除文件**
```
rm -f 文件路径
rm -rf 目录路径
```
**打包**
```
tar -cvf 包名 源文件
tar -zcvf 压缩包名 源文件
```
**解压**
```
tar -zxvf 文件路径
```
**查找符合条件的字符串**
```
grep 字符串
```
**下载**
```
wget 资源路径
```
**查看所有进程**
```
ps -ef
```
**查找某一进程**
```
ps –ef | grep [java]
```
#### echo命令
```
echo [字符串|$变量]
```
#### date命令
**显示当前系统时间**
```
date
```
**设置系统时间**
```
date -s "日期时间"
```
**清屏**
```
clear
```
**杀掉某一进程**
```
kill -9 进程标识
```
**查看网络端口**
```
netstat -an | grep 端口
```
#### 用户管理
**添加用户**
```
useradd 用户名
```
**密码**
```
passwd 用户名
```
**删除用户**
```
userdel -r 用户名
```
**切换用户**
```
ssh -l 用户名 -p 22 主机
```




### CentOS7使用firewalld打开关闭防火墙与端口
```
1.firewalld的基本使用
启动:systemctl start firewalld
关闭:systemctl stop firewalld
查看状态:systemctl status firewalld
开机禁用:systemctl disable firewalld
开机启用:systemctl enable firewalld

2.systemctl是CentOS7的服务管理工具中主要的工具,它融合之前service和chkconfig的功能于一体.
启动一个服务:systemctl start firewalld.service
关闭一个服务:systemctl stop firewalld.service
重启一个服务:systemctl restart firewalld.service
显示一个服务的状态:systemctl status firewalld.service
在开机时启用一个服务:systemctl enable firewalld.service
在开机时禁用一个服务:systemctl disable firewalld.service
查看服务是否开机启动:systemctl is-enabled firewalld.service
查看已启动的服务列表:systemctl list-unit-files|grep enabled
查看启动失败的服务列表:systemctl --failed

3.配置firewalld-cmd
查看版本:firewall-cmd --version
查看帮助:firewall-cmd --help
显示状态:firewall-cmd --state
查看所有打开的端口:firewall-cmd --zone=public --list-ports
更新防火墙规则:firewall-cmd --reload
查看区域信息:firewall-cmd --get-active-zones
查看指定接口所属区域:firewall-cmd --get-zone-of-interface=eth0
拒绝所有包:firewall-cmd --panic-on
取消拒绝状态:firewall-cmd --panic-off
查看是否拒绝:firewall-cmd --query-panic

那怎么开启一个端口呢
添加:firewall-cmd --add-port=80/tcp --permanent(--permanent永久生效,没有此参数重启后失效)
查看:firewall-cmd --permanent --list-ports
使用互联网:firewall-cmd --permanent --list-services
重新载入:firewall-cmd --reload
查看:firewall-cmd --zone= public --query-port=80/tcp
删除:firewall-cmd --remove-port=80/tcp --permanent
```



