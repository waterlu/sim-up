package cn.lu.generator.model;

import cn.lu.generator.common.ProjectType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author lutiehua
 * @date 2017/11/10
 */
@Getter
@Setter
@NoArgsConstructor
public class PropModel extends DataModel {

    /**
     * 服务名称 spring.application.name
     */
    private String serviceName;

    /**
     * 服务端口 server.port
     */
    private int servicePort;

    /**
     * 监控端口
     */
    private int managePort;

    /**
     * 数据库名 spring.datasource.url
     */
    private String dbName;

    /**
     * 实体类包名 mybatis.type-aliases-package
     */
    private String entityPackage;

    /**
     * 项目类型
     */
    private String projectType = ProjectType.PROJECT_TYPE_BOOT;

    /**
     * 是否启用Redis
     */
    private boolean enableRedis;

    /**
     * 是否启用RocketMQ
     */
    private boolean enableRocketMQ;

    /**
     * 是否启用阿里云OSS
     */
    private boolean enableAliOSS;


}
