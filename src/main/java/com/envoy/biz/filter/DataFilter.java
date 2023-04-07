package com.envoy.biz.filter;

import com.envoy.biz.util.ContextHelper;
import com.isyscore.isc.neo.NeoMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shizi
 * @since 2022-06-20 19:50:49
 */
@Slf4j
@Component
public class DataFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String reqId = httpServletRequest.getHeader("x-request-id");
        if (null == reqId || "".equals(reqId)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        NeoMap headMap = NeoMap.of(
            "x-request-id", httpServletRequest.getHeader("x-request-id"),
            "x-b3-traceid", httpServletRequest.getHeader("x-b3-traceid"),
            "x-b3-spanid", httpServletRequest.getHeader("x-b3-spanid"),
            "x-b3-parentspanid", httpServletRequest.getHeader("x-b3-parentspanid"),
            "x-b3-sampled", httpServletRequest.getHeader("x-b3-sampled"),
            "x-b3-flags", httpServletRequest.getHeader("x-b3-flags"),
            "x-ot-span-context", httpServletRequest.getHeader("x-ot-span-context")
        );

        log.info("trace-head：{}, data: {}", headMap.toFastJsonString(), httpServletRequest.getHeaderNames());

        ContextHelper.setData(headMap);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
