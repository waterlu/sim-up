###############################
# 数据库配置
###############################
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://172.17.134.78:3306/${dbName}?useUnicode=true&characterEncoding=utf8
spring.datasource.username=zjht_admin2
spring.datasource.password=zjhttest2
<#if projectType == "SpringCloud">

###############################
# Spring Cloud 配置
###############################

# 注册中心配置
spring.cloud.inetutils.preferred-networks=172.17
spring.cloud.inetutils.ignored-interfaces[0]=eth0
eureka.client.service-url.defaultZone=http://172.17.134.56:10000/eureka/
eureka.instance.prefer-ip-address=true
eureka.instance.instance-id=${r'${spring.cloud.client.ipAddress}'}:${r'${spring.application.name}'}:${r'${server.port}'}
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true

# 开启hystrix
feign.hystrix.enabled=true

# 配置Hystrix的超时时间为10秒（默认1秒）
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=10000

# 使用httpclient，解决@FeignClient的GET方法使用对象参数的问题
feign.httpclient.enabled=true
</#if>
<#if enableRedis>

###############################
# Redis 配置
###############################
# Redis数据库索引（默认为0）
spring.redis.database=0
# Redis服务器地址
spring.redis.host=172.17.134.85
# Redis服务器连接端口
spring.redis.port=6379
# Redis服务器连接密码（默认为空）
spring.redis.password=
# 连接池最大连接数（使用负值表示没有限制）
spring.redis.pool.max-active=5
# 连接池最大阻塞等待时间（使用负值表示没有限制）
spring.redis.pool.max-wait=5000
# 连接池中的最大空闲连接
spring.redis.pool.max-idle=10
# 连接池中的最小空闲连接
spring.redis.pool.min-idle=0
# 连接超时时间（毫秒）
spring.redis.timeout=5000
</#if>
<#if enableRocketMQ>

###############################
# RocketMQ 配置
###############################
# RocketMQ Name Server 地址
rocket-mq.name-server=172.17.134.85:9876
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
aliyun.oss.endpoint=oss-cn-beijing-internal.aliyuncs.com
aliyun.oss.accessKeyId=LTAIVXoYWaKwpbhw
aliyun.oss.accessKeySecret=I5xzTSjkGRteipvlywfQDh4FySzy3n
aliyun.oss.publicBucket=kingold-dev-public
aliyun.oss.privateBucket=kingold-dev-private
aliyun.oss.privateMap=st1-dev.zj-hf.cn
aliyun.oss.publicMap=st2-dev.zj-hf.cn
</#if>