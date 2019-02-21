
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
yum search ifconfig
```

安装包:
```
yum -y install net-tools.x86_64
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








