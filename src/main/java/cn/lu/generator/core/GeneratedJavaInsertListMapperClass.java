package cn.lu.generator.core;

import cn.lu.generator.dto.GeneratorParam;
import cn.lu.generator.dto.TableInfo;
import com.google.common.base.CaseFormat;

/**
 * Created by lutiehua on 2017/9/26.
 */
public class GeneratedJavaInsertListMapperClass extends AbstractGeneratedJavaClass {

    /**
     * 构造函数
     *
     * @param generatorParam
     * @param tableInfo
     */
    public GeneratedJavaInsertListMapperClass(GeneratorParam generatorParam, TableInfo tableInfo) {
        super(generatorParam, tableInfo);

        String keyFieldName = tableInfo.getKey();
        if (null != keyFieldName) {
            keyFieldName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, keyFieldName);
            model.setKeyFieldName(keyFieldName);
        }
    }

    @Override
    public String getTemplateName() {
        return "insert-list-mapper.ftl";
    }

    /**
     * 包名
     *
     * @return
     */
    @Override
    public String getJavaPackageName() {
        return generatorParam.getPackageInfo().getDaoPackage();
    }

    /**
     * 类名后缀
     *
     * @return
     */
    @Override
    public String getJavaClassNamePostfix() {
        return "InsertListMapper";
    }

    /**
     * 类说明后缀
     *
     * @return
     */
    @Override
    public String getJavaClassRemarkPostfix() {
        return "查询参数对象";
    }
}