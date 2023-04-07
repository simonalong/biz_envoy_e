package com.envoy.biz.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shizi
 * @since 2020-12-21 17:28:03
 */
@Data
public class StandardResponse<T> implements Serializable {

    private Integer code = 0;
    private String message = "success";

    private T data;

    public boolean success() {
        return code == 0 || code == 200;
    }
}
