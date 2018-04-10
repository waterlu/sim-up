###############################
# 数据库配置
###############################
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://10.10.10.174:3306/${dbName}?useUnicode=true&characterEncoding=utf8&useSSL=false
spring.datasource.username=zj_admin
spring.datasource.password=123456
<#if projectType == "SpringCloud">

###############################
# Spring Cloud 配置
###############################

# 注册中心配置
spring.cloud.inetutils.preferred-networks=10.10.10
eureka.client.service-url.defaultZone=http://10.10.10.77:10000/eureka/
eureka.instance.prefer-ip-address=true
eureka.instance.instance-id=${r'${spring.cloud.client.ipAddress}'}:${r'${spring.application.name}'}:${r'${server.port}'}
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true

# 开启hystrix
feign.hystrix.enabled=true

# 配置Hystrix的超时时间为5秒（默认1秒）
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=5000

# 使用httpclient，解决@FeignClient的GET方法使用对象参数的问题
feign.httpclient.enabled=true
</#if>
<#if enableRedis>

###############################
# Redis 配置
###############################
# Redis数据库索引（开发环境临时调整为3库）
spring.redis.database=3
# Redis服务器地址
spring.redis.host=10.10.10.182
# Redis服务器连接端口
spring.redis.port=6379
# Redis服务器连接密码（默认为空）
spring.redis.password=
# 连接池最大连接数（使用负值表示没有限制）
spring.redis.pool.max-active=30
# 连接池最大阻塞等待时间（使用负值表示没有限制）
spring.redis.pool.max-wait=30000
# 连接池中的最大空闲连接
spring.redis.pool.max-idle=8
# 连接池中的最小空闲连接
spring.redis.pool.min-idle=0
# 连接超时时间（毫秒）
spring.redis.timeout=0
</#if>
<#if enableRocketMQ>

###############################
# RocketMQ 配置
###############################
# RocketMQ Name Server 地址
rocket-mq.name-server=10.10.10.163:9876
# RocketMQ 非事务型生产者所属的组
rocket-mq.producer-group-name=p-${serviceName}
# RocketMQ 事务型生产者所属的组
rocket-mq.producer-transaction-group-name=pt-${serviceName}
# RocketMQ 发送失败重试次数
rocket-mq.producer-retry=3
# RocketMQ 发送超时时间（毫秒）
rocket-mq.producer-timeout=10000
# RocketMQ 消费者所属的组
rocket-mq.consumer-group-name=c-${serviceName}
</#if>
<#if enableAliOSS>

###############################
# 阿里云OSS 配置
###############################
aliyun.oss.endpoint=oss-cn-beijing.aliyuncs.com
aliyun.oss.accessKeyId=LTAIVXoYWaKwpbhw
aliyun.oss.accessKeySecret=I5xzTSjkGRteipvlywfQDh4FySzy3n
aliyun.oss.publicBucket=kingold-dev-public
aliyun.oss.privateBucket=kingold-dev-private
aliyun.oss.privateMap=st1-dev.zj-hf.cn
aliyun.oss.publicMap=st2-dev.zj-hf.cn
</#if>