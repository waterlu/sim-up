package ${packageName};

import java.util.Map;
import org.springframework.stereotype.Component;
import cn.zjhf.kingold.cloud.common.web.ResponseResult;
import cn.zjhf.kingold.cloud.common.exception.BusinessException;
import cn.zjhf.kingold.cloud.common.vo.ListResultVO;

<#list imports as import>
import ${import.name};
</#list>

/**
 * ${classRemark}接口
 *
 * @author ${author}
 * @date ${date}
 */
@Component
public class ${className} implements ${facadeClassName} {

    /**
     * 创建
     *
     * @param param
     * @return
     * @throws BusinessException
     */
    @Override
    public ResponseResult<${voClassName}> create(${dtoClassName} param) throws BusinessException {
        return ResponseResult.getNetworkExceptionResult();
    }

    /**
     * 查询
     *
     * @param queryParam 对应${paramClassName}类
     * @return
     * @throws BusinessException
     */
    @Override
    public ResponseResult<ListResultVO<${voClassName}>> query(${paramClassName} queryParam) throws BusinessException {
        return ResponseResult.getNetworkExceptionResult();
    }

    /**
     * 详情
     *
     * @param id
     * @return
     * @throws BusinessException
     */
    @Override
    public ResponseResult<${voClassName}> get(Long id) throws BusinessException {
        return ResponseResult.getNetworkExceptionResult();
    }

    /**
     * 更新
     *
     * @param id
     * @param param
     * @return
     * @throws BusinessException
     */
    @Override
    public ResponseResult<String> update(Long id, ${dtoClassName} param) throws BusinessException {
        return ResponseResult.getNetworkExceptionResult();
    }

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws BusinessException
     */
    @Override
    public ResponseResult<String> delete(Long id) throws BusinessException {
        return ResponseResult.getNetworkExceptionResult();
    }
}