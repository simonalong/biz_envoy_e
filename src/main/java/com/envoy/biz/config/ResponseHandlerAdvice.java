package com.envoy.biz.config;

import com.alibaba.fastjson.JSON;
import com.envoy.biz.annotation.AutoResponse;
import com.envoy.biz.pojo.ResponseWrapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

/**
 * 返回值的封装
 *
 * @author shizi
 * @since 2020-12-21 16:22:07
 */
@ControllerAdvice
public class ResponseHandlerAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        Method method = returnType.getMethod();
        if (null != method) {
            if (method.getDeclaringClass().isAnnotationPresent(AutoResponse.class)) {
                return true;
            } else
                return method.isAnnotationPresent(AutoResponse.class);
        }
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
        ServerHttpRequest request, ServerHttpResponse response) {
        // 这里为了解决String转换到其他类型异常
        if (body instanceof String) {
            return JSON.toJSONString(ResponseWrapper.success(body));
        }
        return ResponseWrapper.success(body);
    }
}
