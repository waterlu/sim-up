package cn.lu.generator.model;

import cn.lu.generator.common.ProjectType;
import cn.lu.generator.dto.DependencyInfo;
import cn.lu.generator.dto.ProjectInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author lutiehua
 * @date 2017/11/10
 */
@Getter
@Setter
@NoArgsConstructor
public class PomModel extends DataModel {

    private ProjectInfo projectInfo;

    private List<DependencyInfo> dependencies;

    /**
     * 项目类型
     */
    private String projectType = ProjectType.PROJECT_TYPE_BOOT;

}
