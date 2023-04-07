package com.envoy.biz.config;

import com.isyscore.isc.neo.Neo;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author robot
 */
@Configuration("DbConfiguration")
public class DbConfiguration {

    @Bean("db")
    public Neo db(DataSource dataSource) {
        try {
            Neo neo = Neo.connect(dataSource);
            // 关闭 explain 解析
            neo.setExplainFlag(false);
            // 关闭 sql 耗时监控
            neo.setMonitorFlag(false);
            // 开启日志打印
            neo.setLogPrint(false);
            // 关闭 sql 规范校验
            neo.setStandardFlag(false);
            // ISCDriver.Companion.setShowLog(true);

            return neo;
        } catch (Exception e) {
            LoggerFactory.getLogger(getClass()).warn("neo初始化异常",e);
            return new Neo();
        }
    }
}
