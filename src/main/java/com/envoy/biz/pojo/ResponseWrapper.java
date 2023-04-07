package com.envoy.biz.pojo;

import lombok.Data;
import lombok.experimental.UtilityClass;

import java.io.Serializable;

/**
 * @author robot
 */
@Data
@UtilityClass
public class ResponseWrapper implements Serializable {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public StandardResponse<?> error(Integer code, String message, Object data) {
        StandardResponse response = new StandardResponse<>();
        response.setCode(code);
        response.setData(data);
        response.setMessage(message);
        return response;
    }

    public StandardResponse<?> error(Integer code, String message) {
        StandardResponse<?> response = new StandardResponse<>();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    public <V> StandardResponse<V> success(V data) {
        StandardResponse<V> response = new StandardResponse<>();
        response.setData(data);
        return response;
    }
}
