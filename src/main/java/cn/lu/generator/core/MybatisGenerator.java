package cn.lu.generator.core;

import cn.lu.generator.common.DBDataType;
import cn.lu.generator.common.KeyType;
import cn.lu.generator.dto.GeneratorParam;
import cn.lu.generator.dto.PackageInfo;
import cn.lu.generator.dto.TableInfo;
import cn.lu.generator.entity.DBField;
import com.google.common.base.CaseFormat;
import com.google.common.base.Strings;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成实体类对象和MAPPER文件
 *
 * @author lutiehua
 * @date 2017/11/09
 */
@Component
public class MybatisGenerator {

    /**
     * 通用Mapper基类
     */
    private final static String MAPPER_INTERFACE_UUID = "cn.zjhf.kingold.cloud.common.mapper.SingleTableMapper," +
            "cn.zjhf.kingold.cloud.common.mapper.InsertUuidListMapper";

    private final static String MAPPER_INTERFACE_ID = "cn.zjhf.kingold.cloud.common.mapper.SingleTableMapper,";

    private MybatisShellCallback shellCallback = new MybatisShellCallback();

    private MybatisProgressCallback progressCallback = new MybatisProgressCallback();

    /**
     * 根据表结构自动生成持久化代码
     *
     * @param generatorParam
     * @param tableInfo
     */
    public void generateModelAndMapper(GeneratorParam generatorParam, TableInfo tableInfo) throws Exception {
        Context context = new Context(ModelType.FLAT);
        context.setId("waterlu");
        context.setTargetRuntime("MyBatis3Simple");
        context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");

        // 数据库连接配置，目前只支持MySQL
        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        String dbIP = generatorParam.getDatabaseInfo().getDbIP();
        int dbPort = generatorParam.getDatabaseInfo().getDbPort();
        String dbName = generatorParam.getDatabaseInfo().getDbName();
        String jdbcUrl = String.format("jdbc:mysql://%s:%d/%s?autoReconnect=true&failOverReadOnly=false&useSSL=false", dbIP, dbPort, dbName);
        String dbUsername = generatorParam.getDatabaseInfo().getDbUsername();
        String dbPassword = generatorParam.getDatabaseInfo().getDbPassword();
        jdbcConnectionConfiguration.setConnectionURL(jdbcUrl);
        jdbcConnectionConfiguration.setUserId(dbUsername);
        jdbcConnectionConfiguration.setPassword(dbPassword);
        jdbcConnectionConfiguration.setDriverClass("com.mysql.jdbc.Driver");
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

        // TKMybatis插件
        PluginConfiguration pluginConfiguration = new PluginConfiguration();

        // 增加@Repository注解
        pluginConfiguration.setConfigurationType("cn.zjhf.tool.quicker.core.MybatisMapperPlugin");
//        pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");

        // 定义Mapper基类
        if (KeyType.KEY_TYPE_ID.equalsIgnoreCase(tableInfo.getKeyType())) {
            // 基础表名
            String tableName = tableInfo.getName();

            // 基础类名
            String modelName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase());

            // Package信息
            PackageInfo packageInfo = generatorParam.getPackageInfo();

            // 基础包名
            String basePackage = packageInfo.getBasePackage();

            // 类名
            String insertListClassName = String.format("%s.%s.%sInsertListMapper", basePackage, packageInfo.getDaoPackage(), modelName);

            // ID主键，定义InsertListMapper，并指定主键
            String basicClassName = MAPPER_INTERFACE_ID + insertListClassName;
            pluginConfiguration.addProperty("mappers", basicClassName);
        } else if (KeyType.KEY_TYPE_UUID.equalsIgnoreCase(tableInfo.getKeyType())) {
            // UUID主键，使用common-mybatis中自定义InsertUuidListMapper
            pluginConfiguration.addProperty("mappers", MAPPER_INTERFACE_UUID);
        }

        pluginConfiguration.addProperty("forceAnnotation", "true");
        context.addPluginConfiguration(pluginConfiguration);

        // Java实体类
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        String projectPath = generatorParam.getPackageInfo().getProjectPath();
        String javaPath = generatorParam.getPackageInfo().getJavaPath();
        javaModelGeneratorConfiguration.setTargetProject(projectPath + "/" + javaPath);
        String basePackage = generatorParam.getPackageInfo().getBasePackage();
        String entityPackage = generatorParam.getPackageInfo().getEntityPackage();
        javaModelGeneratorConfiguration.setTargetPackage(basePackage + "." + entityPackage);
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        // Mapper.xml文件
        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        String resourcePath = generatorParam.getPackageInfo().getResourcePath();
        sqlMapGeneratorConfiguration.setTargetProject(projectPath + "/" +  resourcePath);
        sqlMapGeneratorConfiguration.setTargetPackage("mybatis/mapper");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

        // JAVA Mapper类
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetProject(projectPath + "/" + javaPath);
        String daoPackage = generatorParam.getPackageInfo().getDaoPackage();
        javaClientGeneratorConfiguration.setTargetPackage(basePackage + "." + daoPackage);
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

        // 数据源表
        String tableName = tableInfo.getName();
        String modelName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase());
        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(tableName);
        if (!Strings.isNullOrEmpty(modelName)) {
            tableConfiguration.setDomainObjectName(modelName);
        }

        for (DBField field : tableInfo.getFieldList()) {
            // 设置JavaType，TINYINT(Byte => Integer)
            if (field.getDataType() == DBDataType.TINYINT || field.getDataType() == DBDataType.SMALLINT) {
                ColumnOverride columnOverride = new ColumnOverride(field.getColumnName());
                columnOverride.setJavaType("java.lang.Integer");
                tableConfiguration.addColumnOverride(columnOverride);
            }

            // 主键生成
            if (field.isPrimaryKey()) {
                if (KeyType.KEY_TYPE_ID.equalsIgnoreCase(tableInfo.getKeyType()) && field.getDataType() == DBDataType.BIGINT) {
                    tableConfiguration.setGeneratedKey(new GeneratedKey(field.getColumnName(), "JDBC", true, null));
                }
            }
        }

        context.addTableConfiguration(tableConfiguration);

        List<String> warnings = new ArrayList<>();
        MyBatisGenerator generator;
        try {
            Configuration config = new Configuration();
            config.addContext(context);
            config.validate();

            generator = new MyBatisGenerator(config, shellCallback, warnings);
            generator.generate(progressCallback);
        } catch (Exception e) {
            throw new RuntimeException("生成Model和Mapper失败", e);
        }

        if (generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
            throw new RuntimeException("生成Model和Mapper失败：" + warnings);
        }
        if (Strings.isNullOrEmpty(modelName)) {
            modelName = tableNameConvertUpperCamel(tableName);
        }
    }

    /**
     * 数据库表名 => 实体对象名
     * lower_underscore => lowerCamel
     *
     * @param tableName
     * @return
     */
    private String tableNameConvertUpperCamel(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase());
    }

}
