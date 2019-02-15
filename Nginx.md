
# Nginx 笔记

Nginx:/usr/local/java/nginx-1.13.9
启动服务路径:/usr/local/nginx/sbin/
./nginx
配置集群:/usr/local/nginx/conf/nginx.conf
加:
upstream server_siyuan{
	server 127.0.0.1:8080;
	..
	ip_hash;
}
server.location中加:
proxy_pass http://server_siyuan;
重启Nginx服务.



























