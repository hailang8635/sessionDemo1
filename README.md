# Tomcat Session Manager
## 一， Load balancing of requests using Nginx
### eg: config in nginx.conf
        server                  localhost:8080 weight=1;
        server                  localhost:8081 weight=5;
        server                  localhost:8082 weight=5;
        server                  localhost:8083 weight=5;
        

## 二， Tomcat Config
### 1， Tomcat version && Jdk version
* apache-tomcat-7.0.85
* Java(TM) SE Runtime Environment (build 1.8.0_91-b14)
### 2， APP1, APP2, APP3 config in context.xml
    <Valve className="com.orangefunction.tomcat.redissessions.RedisSessionHandlerValve" />
    <Manager className="com.orangefunction.tomcat.redissessions.RedisSessionManager" 
        host="192.168.1.166" 
        port="6379" 
        database="2" 
        maxInactiveInterval="60"/>
        
### 3， APP1, APP2, APP3 change ports, config in server.xml
* APP1's port: 8080
* APP2's port: 8081
* APP3's port: 8082
### 4， Import three jars into tomcat
  * [commons-pool2-2.4.2.jar](https://github.com/hailang8635/sessionDemo1/blob/master/WebContent/conf/tomcat-lib/commons-pool2-2.4.2.jar)
  * [jedis-2.6.2.jar](https://github.com/hailang8635/sessionDemo1/blob/master/WebContent/conf/tomcat-lib/jedis-2.6.2.jar)
  * [tomcat-redis-session-manager1.2.jar](https://github.com/hailang8635/sessionDemo1/blob/master/WebContent/conf/tomcat-lib/tomcat-redis-session-manager1.2.jar)
