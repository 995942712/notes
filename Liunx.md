
# Liunx 命令

Liunx命令大全：https://www.linuxprobe.com

**关机**

`shutdown -h now`

**echo命令**

`echo [字符串|$变量]`

**date命令**




**开启网络连接**

`cd /etc/sysconfig/network-scripts/`

把 ONBOOT 改为yes

`vi ifcfg-eno`

重启服务

`service network restart`

**ifconfig安装**

下载包:

`yum search ifconfig`

安装包:

`yum -y install net-tools.x86_64`










