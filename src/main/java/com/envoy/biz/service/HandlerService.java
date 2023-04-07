package com.envoy.biz.service;

import com.envoy.biz.util.ContextHelper;
import com.envoy.biz.util.HttpHelper;
import com.isyscore.isc.neo.Columns;
import com.isyscore.isc.neo.Neo;
import com.isyscore.isc.neo.NeoMap;
import com.isyscore.isc.neo.util.TimeUtils;
import okhttp3.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author shizi
 * @since 2022-06-14 20:40:12
 */
@Service
public class HandlerService {

    @Value("${biz.url.f}")
    private String dUrl;
    @Autowired
    private Neo db;

    public String de(Boolean haveMysql) {
        if (haveMysql) {
            db.update("biz-e-service", NeoMap.of("id", 1, "times", TimeUtils.longToString(System.currentTimeMillis())), Columns.of("id"));
        }
        Headers headers = Headers.of(ContextHelper.getData().getDataMapAssignValueType(String.class));
        return HttpHelper.getOfStandard(String.class, dUrl + "/api/f/ef/" + haveMysql, headers);
    }

    public String be(Boolean haveMysql) {
        if (haveMysql) {
            db.update("biz-e-service", NeoMap.of("id", 1, "times", TimeUtils.longToString(System.currentTimeMillis())), Columns.of("id"));
        }
        Headers headers = Headers.of(ContextHelper.getData().getDataMapAssignValueType(String.class));
        return HttpHelper.getOfStandard(String.class, dUrl + "/api/f/ef/" + haveMysql, headers);
    }
}
