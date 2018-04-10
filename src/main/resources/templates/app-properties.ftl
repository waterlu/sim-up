###############################
# 切换环境
###############################
spring.profiles.active=dev

###############################
# 服务端口
###############################
server.port=${servicePort?c}

###############################
# 日志配置
###############################
logging.config=classpath:log4j2.xml

###############################
# mybatis配置
###############################
#mybatis.config-location=classpath:mybatis/mybatis-config.xml
mybatis.mapper-locations=classpath:mybatis/mapper/*.xml
mybatis.type-aliases-package=${entityPackage}

###############################
# 通用mapper3配置
###############################
mapper.not-empty=false
mapper.identity=MYSQL

# 为了返回自动生成的UUID
mapper.before=true

# 非常重要，自定义的mapper基类需要在这里声明，提前进行初始化，否则构造SQLProvider时会抛异常
mapper.mappers=cn.zjhf.kingold.cloud.common.mapper.SingleTableMapper,cn.zjhf.kingold.cloud.common.mapper.InsertUuidListMapper

###############################
# 分页配置
###############################
pagehelper.helperDialect=mysql

# 执行查询语句前先执行 select count()
pagehelper.row-bounds-with-count=true

# 不合理的页面信息返回空数据
pagehelper.reasonable=false

# 分页采用offset,limit形式
pagehelper.offset-as-page-num=false
pagehelper.supportMethodsArguments=true
pagehelper.params=count=countSql

###############################
# 监控配置
###############################

# 关闭自动热部署
spring.devtools.restart.enabled=false

# actuator接口不需要密码验证
management.security.enabled=false

# 启用actuator的shutdown
endpoints.shutdown.enabled=true

# actuator的shutdown接口不需要密码验证
endpoints.shutdown.sensitive=false

# actuator的metrics接口不需要密码验证
endpoints.metrics.sensitive=false

# actuator的health接口不需要密码验证
endpoints.health.sensitive=false