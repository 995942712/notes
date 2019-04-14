
# Nginx 笔记

### 在 Linux 上安装
1. gcc 安装
```
yum install gcc-c++
```

2. PCRE pcre-devel 安装
```
yum install -y pcre pcre-devel
```

3. zlib 安装
```
yum install -y zlib zlib-devel
```

4. OpenSSL 安装
```
yum install -y openssl openssl-devel
```

5. 解压
```
tar -zxvf nginx-1.10.1.tar.gz
cd nginx-1.10.1
```

6. 配置
```
./configure
```

7. 编译安装
```
make
make install
```

8. 查找安装路径
```
whereis nginx
```

9. 启动、停止nginx
```
cd /usr/local/nginx/sbin/
./nginx 
./nginx -s stop
./nginx -s quit
./nginx -s reload

查询nginx进程
ps aux|grep nginx

重启 nginx
./nginx -s quit
./nginx
```







































