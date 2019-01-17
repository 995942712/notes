
# Java 笔记

Jdk:/usr/local/java/jdk1.8

rpm -qa | grep jdk
yum -y remove java-1.4.2-gcj-compat-1.4.2.0-40jpp.115


# vi /etc/profile 　　 
　　export JAVA_HOME=/usr/java/jdk-1.6.0_22-fcs 
　　export CLASSPATH=$CLASSPATH:$JAVA_HOME/lib:$JAVA_HOME/jre/lib 
　　export PATH=$JAVA_HOME/bin:$JAVA_HOME/jre/bin:$PATH:$HOME/bin

# source /etc/profile













