package com.envoy.biz.util;

import com.isyscore.isc.neo.NeoMap;
import lombok.experimental.UtilityClass;

/**
 * @author shizi
 * @since 2022-06-20 19:53:10
 */
@UtilityClass
public class ContextHelper {

    private ThreadLocal<NeoMap> localData = ThreadLocal.withInitial(NeoMap::of);

    public void setData(NeoMap data) {
        localData.set(data);
    }

    public NeoMap getData() {
        return localData.get();
    }
}
