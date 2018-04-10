package cn.lu.common.web;

/**
 * 返回结果data是字符串
 *
 * @author lutiehua
 * @date 2018/2/7
 */
public class SimpleResponseResult extends ResponseResult<String> {

    /**
     *
     * @param data
     */
    public SimpleResponseResult(String data) {
        super();
        this.setData(data);
    }

}