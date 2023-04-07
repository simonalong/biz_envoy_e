package com.envoy.biz.annotation;

import java.lang.annotation.*;

/**
 * 添加该注解，则自动添加返回值
 * @author shizi
 * @since 2020-12-21 16:50:55
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface AutoResponse {}
