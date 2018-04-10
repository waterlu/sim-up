package cn.lu.common.doc.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xiaody
 * @description
 * @date create in 17/11/15
 */
@Setter
@Getter
public class InterfaceModel {

    private String name;
    private String desc;
    private String url;
    private String method;
    private RequestModel request;
    private ResponseModel response;
}
