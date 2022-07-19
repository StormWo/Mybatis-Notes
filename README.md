# Mybatis-notes

个人复习用Mybatis笔记

# Javaweb学习笔记

## 什么是Maven

#### 引言

假设开发A、B两个项目，A项目的一些功能要依赖于B项目中的某些类，如何维持这种依赖关系？
简单情况下可以把B项目打成jar包，然后在A项目的Library下导入B的jar文件

##### 缺陷

B中发现bug修改后又要重新打包
为了保证A的jar运行就必须要依赖B的jar

##### 解决办法

MAVEN文件项目的pom.xml文件

### Maven定义

Maven是基于项目对象模型(POM project object model)，可以通过一小段描述信息（配置）来管理项目的构建，报告和文档的软件项目管理工具
在Java项目和web项目的上面包裹了一层maven

### pom.xml

pom.xml通过groupId、artifactId、version三个属性就能定位一个jar包
加入上面的pom.xml文件属于A项目，那么A项目肯定是一个maven项目，通过上面这三个属性能够找到junit对应版本的jar包，那么junit项目肯定也是一个maven项目，junit的maven项目中的pom.xml文件就会有三个标识符

## Mybatis

官网：https://mybatis.org/mybatis-3/zh/index.html

### pom文件依赖

```xml
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.10</version>
    </dependency>
<!--数据库依赖-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.29</version>
        </dependency>
<!--junit单元测试-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
<!--日志-->
        <!-- -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.36</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.11</version>
        </dependency>
		<dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-core</artifactId>
            <version>1.2.11</version>
    </dependency>
```


### Mybatis的配置文件mybatis-config.xml

resource目录下的mybatis-config.xml
环境配置


```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

<!--    <typeAliases>-->
<!--        <package name="org.example"/>-->
<!--    </typeAliases>-->


<environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <!--数据库的连接信息-->
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <!--<property name="url" value="jdbc:mysql://mybatis?useSSL=false"/>-->
                <property name="url" value="jdbc:mysql: //localhost:3306/mybatis?useUnicode=true;characterEncoding=UTF-8;autoReconnect=true;failOverReadOnly=false"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
</environments>
    <mappers>   <!--指定当前的sqlsession映射文件路径-->
    <mapper resource="org/example/mapper/BrandMapper.xml"/>
    </mappers>
</configuration>
```
##### 注意

文件存放于resource目录下

<mapper>标签记载映射的Mapper.xml文件目录，从src/java/resources之后算起

### Mapper.xml文件配置

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!--namespace：名称空间-->
<mapper namespace="org.example.mapper.BrandMapper">
    <select id="selectById" resultMap="brandResultMap">
        select * from tb_brand where id = #{id};
    </select>
 <mapper/>
```

### 数据库举例

brand类有

```mysql
drop table if exists tb_brand;
create table tb_brand(
    id int primary key auto_increment,
    brand_name  varchar(20),
    company_name varchar(20),
    ordered int,
    `description` varchar(100),
    `status` int

       )default charset = utf8;
```

插入数据

```mysql
insert into tb_brand(brand_name, company_name, ordered, description, status)
values ('三只松鼠','三只松鼠有限公司',5,'好吃不上火',0),
       ('华为','华为技术有限公司',100,'智能世界', 1),
       ('小米','小米科技有限公司',50,'are you ok',1);

```

#### 字段映射

由于Java采用驼峰命名法，SQL一律采用小写字母下划线组合

需要加入映射在<mapper>中间

```xml
<resultMap id="brandResultMap" type="org.example.pojo.Brand">
    <!--
    *   id：完成主键字段的映射
            resul：完成一般字段的映射
            column:表的列名
            property：实体类的属性名
    * resulMap
            定义<resultMap>标签
            在<select>标签中，使用resultMap属性替换resultType标签
    -->
    <result column="brand_name" property="brandName"/>
    <result column="company_name" property="companyName"/>
</resultMap>

```





## SpringMVC

Spring+MVC

### HelloWorld

#### 1、开发环境

IDE:idea 2022.1

构建工具：maven3.8.1

服务器：tomcat

Spring：5.

#### 2、创建maven工程

###### a.添加web模块

###### b.打包方式war

###### c.引入依赖

