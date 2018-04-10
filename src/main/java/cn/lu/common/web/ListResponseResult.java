package cn.lu.common.web;

import cn.zjhf.kingold.cloud.common.vo.ListResultVO;

/**
 * 返回结果data是对象列表
 *
 * @author lutiehua
 * @date 2018/2/7
 */
public class ListResponseResult<T> extends ResponseResult<ListResultVO<T>> {

    public ListResponseResult() {
        super();
    }

}