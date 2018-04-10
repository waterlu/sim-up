package cn.lu.generator.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 项目信息
 *
 * @author lutiehua
 * @date 2017/9/26
 */
@Data
public class ProjectInfo {

    @NotBlank
    private String groupId;

    @NotBlank
    private String artifactId;

    /**
     * 服务端口
     */
    private Integer port;

    private String version;

    private String name;

    private String description;

    /**
     * JDK 版本
     */
    private String javaVersion;

    /**
     * Spring Boot 版本
     */
    private String springBootVersion;

    /**
     * Spring Cloud 版本
     */
    private String springCloudVersion;

    /**
     * 项目类型
     */
    @NotBlank
    private String projectType;
}
