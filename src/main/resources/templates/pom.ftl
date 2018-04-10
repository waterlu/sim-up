<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>${projectInfo.groupId}</groupId>
    <artifactId>${projectInfo.artifactId}</artifactId>
    <version>${projectInfo.version}</version>
    <packaging>jar</packaging>

    <name>${projectInfo.name}</name>
    <description>${projectInfo.description}</description>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>${projectInfo.springBootVersion}</version>
        <relativePath/>
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>${projectInfo.javaVersion}</java.version>
    </properties>

    <dependencies>

        <!-- spring-boot-starter -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-logging</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <!-- log4j2 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-log4j2</artifactId>
        </dependency>

        <!-- test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- 监控 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <!-- common-web -->
        <dependency>
            <groupId>cn.zjhf.kingold.cloud.common</groupId>
            <artifactId>common-web</artifactId>
            <version>1.0.0-SNAPSHOT</version>
        </dependency>

        <!-- common-tool -->
        <dependency>
            <groupId>cn.zjhf.kingold.cloud.common</groupId>
            <artifactId>common-tool</artifactId>
            <version>1.0.0-SNAPSHOT</version>
        </dependency>

        <!-- common-mybatis -->
        <dependency>
            <groupId>cn.zjhf.kingold.cloud.common</groupId>
            <artifactId>common-mybatis</artifactId>
            <version>1.0.0-SNAPSHOT</version>
        </dependency>

        <!-- project-generator -->
        <dependency>
            <groupId>cn.zjhf.tool.quicker</groupId>
            <artifactId>spring-cloud-project-generator</artifactId>
            <version>0.2.0-SNAPSHOT</version>
        </dependency>

    </dependencies>

    <#if projectType == "SpringCloud">
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${projectInfo.springCloudVersion}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    </#if>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <executions>
                    <execution>
                        <goals>
                            <goal>build-info</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>${projectInfo.javaVersion}</source>
                    <target>${projectInfo.javaVersion}</target>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
