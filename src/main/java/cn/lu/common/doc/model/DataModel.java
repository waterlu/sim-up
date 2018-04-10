package cn.lu.common.doc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xiaody
 * @description
 * @date create in 17/11/15
 */
@Setter
@Getter
@AllArgsConstructor
public class DataModel {

    private String name;
    private boolean required = false;
    private String type;
    private String desc;
}
