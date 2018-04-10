package cn.lu.generator.core;

import cn.lu.generator.dto.GeneratorParam;
import cn.lu.generator.dto.TableInfo;

/**
 * 生成Feign配置文件类
 *
 * @author lutiehua
 * @date 2017/11/14
 */
public class GeneratedJavaFeignConfigClass extends AbstractGeneratedJavaClass {

    public GeneratedJavaFeignConfigClass(GeneratorParam generatorParam, TableInfo tableInfo) {
        super(generatorParam, tableInfo);
    }

    /**
     * 模板名称
     *
     * @return
     */
    @Override
    public String getTemplateName() {
        return "cloud/feign-config.ftl";
    }

    /**
     * 包名
     *
     * @return
     */
    @Override
    public String getJavaPackageName() {
        return generatorParam.getPackageInfo().getControllerPackage();
    }

    /**
     * 留给子类覆盖用
     *
     * @return
     */
    @Override
    protected String getJavaClassName() {
        return "FeignConfig";
    }

    /**
     * 类名后缀
     *
     * @return
     */
    @Override
    public String getJavaClassNamePostfix() {
        return "";
    }

    /**
     * 留给子类覆盖用
     *
     * @return
     */
    @Override
    protected String getJavaClassRemark() {
        return "Feign配置类";
    }

    /**
     * 类说明后缀
     *
     * @return
     */
    @Override
    public String getJavaClassRemarkPostfix() {
        return "";
    }
}
