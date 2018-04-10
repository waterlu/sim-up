package cn.lu.generator.core;

import cn.lu.generator.common.KeyType;
import cn.lu.generator.dto.GeneratorParam;
import cn.lu.generator.dto.TableInfo;
import com.google.common.base.CaseFormat;

/**
 * Created by lutiehua on 2017/9/28.
 */
public class GeneratedJavaServiceImplClass extends AbstractGeneratedJavaTemplateClass {


    public GeneratedJavaServiceImplClass(GeneratorParam generatorParam, TableInfo tableInfo) {
        super(generatorParam, tableInfo);

        String keyFieldName = tableInfo.getKey();
        if (null != keyFieldName) {
            keyFieldName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, keyFieldName);
            model.setKeyFieldName(keyFieldName);
        }
    }

    /**
     * 模板
     *
     * @return
     */
    @Override
    public String getTemplateName() throws Exception {
        if (KeyType.KEY_TYPE_UUID.equalsIgnoreCase(tableInfo.getKeyType())) {
            return "service-impl-uuid.ftl";
        } else if (KeyType.KEY_TYPE_ID.equalsIgnoreCase(tableInfo.getKeyType())) {
            return "service-impl-id.ftl";
        } else {
            throw new Exception("Unexpected key type = [" + tableInfo.getKeyType() + "]");
        }
    }


    /**
     * 包名
     *
     * @return
     */
    @Override
    public String getJavaPackageName() {
        return generatorParam.getPackageInfo().getServicePackage() + ".impl";
    }

    /**
     * 类名后缀
     *
     * @return
     */
    @Override
    public String getJavaClassNamePostfix() {
        return "ServiceImpl";
    }

    /**
     * 类说明后缀
     *
     * @return
     */
    @Override
    public String getJavaClassRemarkPostfix() {
        return "服务实现类";
    }
}
