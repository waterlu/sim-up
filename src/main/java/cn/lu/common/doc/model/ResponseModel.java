package cn.lu.common.doc.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xiaody
 * @description
 * @date create in 17/11/15
 */
@Setter
@Getter
public class ResponseModel {
    private List<DataModel> result;
    private String sample;
}
