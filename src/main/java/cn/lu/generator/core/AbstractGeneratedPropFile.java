package cn.lu.generator.core;

import cn.lu.generator.common.DependenceType;
import cn.lu.generator.dto.DependencyInfo;
import cn.lu.generator.dto.GeneratorParam;
import cn.lu.generator.model.DataModel;
import cn.lu.generator.model.PropModel;

/**
 * 属性文件生成类的抽象基类
 *
 * @author lutiehua
 * @date 2017/11/10
 */
public abstract class AbstractGeneratedPropFile extends AbstractGeneratedFile {

    protected PropModel model;

    public AbstractGeneratedPropFile(GeneratorParam generatorParam) {
        super(generatorParam);

        model = new PropModel();

        int port = generatorParam.getProjectInfo().getPort();
        int managePort = port + 10000;

        model.setDbName(generatorParam.getDatabaseInfo().getDbName());
        model.setManagePort(managePort);
        model.setServiceName(generatorParam.getProjectInfo().getName());
        model.setServicePort(port);
        model.setServiceName(generatorParam.getProjectInfo().getArtifactId());
        model.setProjectType(generatorParam.getProjectInfo().getProjectType());

        for (DependencyInfo dependencyInfo : generatorParam.getDependencies()) {
            String name = dependencyInfo.getArtifactId();

            if (DependenceType.REDIS.equalsIgnoreCase(name)) {
                model.setEnableRedis(true);
            }
            if (DependenceType.MQ.equalsIgnoreCase(name)) {
                model.setEnableRocketMQ(true);
            }
            if (DependenceType.OSS.equalsIgnoreCase(name)) {
                model.setEnableAliOSS(true);
            }
        }
    }

    /**
     * 变量数据
     *
     * @return
     */
    @Override
    public DataModel getDataModel() {
        return model;
    }
}
