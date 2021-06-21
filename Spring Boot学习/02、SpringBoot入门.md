# SpringBoot入门

## 1、系统需求

- [Java8]() & 兼容Java14
  - **java -version** 查看jdk版本
- Maven3.3+
  - **mvn -v** 查看maven版本
- idea2019.1.2

### 1.1、Maven设置

~~~xml
<mirrors>
      <mirror>
        <id>nexus-aliyun</id>
        <mirrorOf>central</mirrorOf>
        <name>Nexus aliyun</name>
        <url>http://maven.aliyun.com/nexus/content/groups/public</url>
      </mirror>
  </mirrors>
 
  <profiles>
         <profile>
              <id>jdk-1.8</id>
              <activation>
                <activeByDefault>true</activeByDefault>
                <jdk>1.8</jdk>
              </activation>
              <properties>
                <maven.compiler.source>1.8</maven.compiler.source>
                <maven.compiler.target>1.8</maven.compiler.target>
                <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
              </properties>
         </profile>
  </profiles>
~~~

更换国内源

## 2、Hello World

需求：向浏览器发送/hello请求，响应hello，SpringBoot2

### 2.1、建立maven工程

### 2.2、导入依赖

~~~ xml
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.4.RELEASE</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

    </dependencies>
~~~

### 2.3、创建主程序

~~~ java
/**
 * 主程序类
 * @SpringBootApplication：这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}
~~~

### 2.4、编写业务

~~~ java
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String handle01(){
        return "Hello, Spring Boot 2!"; //返回一个字符串为浏览器上显示
    }
}
~~~

### 2.5、测试

运行main方法

~~~ shell
$ mvn spring-boot:run

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::  (v2.5.1)
....... . . .
....... . . . (log output here)
....... . . .
........ Started MyApplication in 2.222 seconds (JVM running for 6.514)

~~~

### 2.6、简化配置

#### 2.6.1、在resources文件下建立application.properties文件

~~~ xml
server.port=8888（改变端口）
~~~

### 2.7、简化部署

#### 2.7.1、添加打包jar插件

~~~ xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>

~~~

#### 2.7.2、将jar打包

~~~ shell
$ mvn package

[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building myproject 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] .... ..
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ myproject ---
[INFO] Building jar: /Users/developer/example/spring-boot-example/target/myproject-0.0.1-SNAPSHOT.jar
[INFO]
[INFO] --- spring-boot-maven-plugin:2.5.1:repackage (default) @ myproject ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

~~~

#### 2.7.3、终端运行jar包

~~~ shell
$ jar tvf target/myproject-0.0.1-SNAPSHOT.jar（文件所在路劲）
~~~

~~~ shell
$ java -jar target/myproject-0.0.1-SNAPSHOT.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::  (v2.5.1)
....... . . .
....... . . . (log output here)
....... . . .
........ Started MyApplication in 2.536 seconds (JVM running for 2.864)

~~~

