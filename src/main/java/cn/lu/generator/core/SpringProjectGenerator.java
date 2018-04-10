package cn.lu.generator.core;

import cn.lu.generator.common.*;
import cn.lu.generator.dto.DatabaseInfo;
import cn.lu.generator.dto.GeneratorParam;
import cn.lu.generator.dto.TableInfo;
import cn.lu.generator.entity.DBField;
import com.google.common.base.Strings;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 自动生成项目代码的入口
 *
 * @author lutiehua
 * @date 2018/2/28
 */
@Component
public class SpringProjectGenerator implements Generator {

    private SpringBootProjectGenerator bootProjectGenerator = new SpringBootProjectGenerator();

    private SpringCloudProjectGenerator cloudProjectGenerator = new SpringCloudProjectGenerator();

    private final static String YES = "YES";

    /**
     * 自动生成工程和代码
     *
     * @param generatorParam
     * @throws Exception
     */
    @Override
    public void generateProject(GeneratorParam generatorParam) throws Exception {
        // 项目类型
        String projectType = generatorParam.getProjectInfo().getProjectType();

        // 数据库设置
        DatabaseInfo databaseInfo = generatorParam.getDatabaseInfo();

        // 表
        List<TableInfo> tableInfoList = generatorParam.getTables();

        // 读取并补充表结构信息
        for (TableInfo tableInfo : tableInfoList) {
            readTableInfo(databaseInfo, tableInfo);
        }

        if (ProjectType.PROJECT_TYPE_BOOT.equalsIgnoreCase(projectType)) {
            // 生成SpringBoot项目文件
            bootProjectGenerator.generateProject(generatorParam);
        } else if (ProjectType.PROJECT_TYPE_CLOUD.equalsIgnoreCase(projectType)) {
            // 生成SpringCloud项目文件
            cloudProjectGenerator.generateProject(generatorParam);
        } else {
            // 不支持的项目类型，抛出异常
            String message = String.format("unknown projectType=%s", projectType);
            throw new Exception(message);
        }
    }

    /**
     * 自动生成代码
     *
     * @param generatorParam
     * @throws Exception
     */
    @Override
    public void generateCode(GeneratorParam generatorParam) throws Exception {
        // 项目类型
        String projectType = generatorParam.getProjectInfo().getProjectType();

        // 数据库设置
        DatabaseInfo databaseInfo = generatorParam.getDatabaseInfo();

        // 表
        List<TableInfo> tableInfoList = generatorParam.getTables();

        // 读取并补充表结构信息
        for (TableInfo tableInfo : tableInfoList) {
            readTableInfo(databaseInfo, tableInfo);
        }

        if (ProjectType.PROJECT_TYPE_BOOT.equalsIgnoreCase(projectType)) {
            // 生成SpringBoot代码
            bootProjectGenerator.generateCode(generatorParam);
        } else if (ProjectType.PROJECT_TYPE_CLOUD.equalsIgnoreCase(projectType)) {
            // 生成SpringCloud代码
            cloudProjectGenerator.generateCode(generatorParam);
        } else {
            // 不支持的项目类型，抛出异常
            String message = String.format("unknown projectType=%s", projectType);
            throw new Exception(message);
        }
    }

    /**
     * 读取表结构信息
     *
     * @param databaseInfo
     * @param tableInfo
     * @throws Exception
     */
    protected void readTableInfo(DatabaseInfo databaseInfo, TableInfo tableInfo) throws Exception {
        // 表名
        String tableName = tableInfo.getName();
        if (Strings.isNullOrEmpty(tableName)) {
            return;
        }

        // 数据库连接
        Connection connection = getConnection(databaseInfo);

        // 元信息
        DatabaseMetaData metaData = connection.getMetaData();

        // 表注释
        String[] types = { "TABLE", "VIEW" };
        String schemaPattern = databaseInfo.getDbUsername().toUpperCase();
        ResultSet resultSet = metaData.getTables(null, schemaPattern, tableName, types);
        while (resultSet.next()) {
            String name = resultSet.getString("TABLE_NAME");
            String type = resultSet.getString("TABLE_TYPE");
            String remark = resultSet.getString("REMARKS");
            if (tableName.equalsIgnoreCase(name)) {
                if (Strings.isNullOrEmpty(tableInfo.getRemark())) {
                    tableInfo.setRemark(remark);
                }
                break;
            }
        }
        resultSet.close();

        // 主键信息
        String primaryKeyFiledName = getTablePrimaryKey(metaData, tableName);
        if (Strings.isNullOrEmpty(tableInfo.getKey())) {
            if (Strings.isNullOrEmpty(primaryKeyFiledName)) {
                // 表必须有主键
                throw new MissingKeyFieldException(tableName);
            }
            tableInfo.setKey(primaryKeyFiledName);
        }

        // 字段信息
        DBField primaryKeyFiled = null;
        resultSet = metaData.getColumns(null, null, tableName, null);
        List<DBField> fieldList = new ArrayList<>();
        while (resultSet.next()) {
            DBField field = new DBField();
            // 列名
            field.setColumnName(resultSet.getString("COLUMN_NAME"));
            // 类型
            field.setDataType(resultSet.getInt("DATA_TYPE"));
            // 类型名称
            field.setTypeName(resultSet.getString("TYPE_NAME"));
            // 注释
            field.setRemarks(resultSet.getString("REMARKS"));
            // 是否自增
            field.setAutoIncrement(YES.equalsIgnoreCase(resultSet.getString("IS_AUTOINCREMENT")));
            // 是否可空
            field.setNullable(YES.equalsIgnoreCase(resultSet.getString("IS_NULLABLE")));
            // 是否主键
            if (primaryKeyFiledName.equalsIgnoreCase(field.getColumnName())) {
                field.setPrimaryKey(true);
                primaryKeyFiled = field;
            } else {
                field.setPrimaryKey(false);
            }
            fieldList.add(field);
        }

        if (Strings.isNullOrEmpty(tableInfo.getKeyType())) {
            // 自动判断KeyType
            if (primaryKeyFiled.isAutoIncrement()) {
                tableInfo.setKeyType(KeyType.KEY_TYPE_ID);
            } else {
                if (primaryKeyFiled.getDataType() == DBDataType.CHAR || primaryKeyFiled.getDataType() == DBDataType.VARCHAR) {
                    tableInfo.setKeyType(KeyType.KEY_TYPE_UUID);
                } else {
                    throw new UnknownKeyTypeException(tableName);
                }
            }
        }

        tableInfo.setFieldList(fieldList);
    }

    /**
     * 获取数据库连接
     *
     * @return
     * @throws Exception
     */
    protected Connection getConnection(DatabaseInfo databaseInfo) throws Exception {
        DriverManager.setLoginTimeout(3);
        DBType dbType = DBType.valueOf(databaseInfo.getDbType());
        Class.forName(dbType.getDriverClass());
        String url = getConnectionURL(databaseInfo);
        Properties props = new Properties();
        props.setProperty("user", databaseInfo.getDbUsername());
        props.setProperty("password", databaseInfo.getDbPassword());
        //设置可以获取remarks信息
        props.setProperty("remarks", "true");
        //设置可以获取tables remarks信息
        props.setProperty("useInformationSchema", "true");
        Connection connection = DriverManager.getConnection(url, props);
        return connection;
    }

    protected String getConnectionURL(DatabaseInfo databaseInfo) throws ClassNotFoundException {
        DBType dbType = DBType.valueOf(databaseInfo.getDbType());
        String connectionRUL = String.format(dbType.getConnectionUrlPattern(), databaseInfo.getDbIP(),
                databaseInfo.getDbPort(), databaseInfo.getDbName());
        return connectionRUL;
    }

    /**
     * 读取主键
     *
     * @param metaData
     * @param tableName
     * @return
     * @throws Exception
     */
    protected String getTablePrimaryKey(DatabaseMetaData metaData, String tableName) throws Exception {
        ResultSet rs = metaData.getPrimaryKeys(null, null, tableName);
        while (rs.next()) {
            return rs.getString("COLUMN_NAME");
        }

        return null;
    }
}
