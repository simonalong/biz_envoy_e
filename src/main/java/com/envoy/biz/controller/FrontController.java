package com.envoy.biz.controller;

import com.envoy.biz.annotation.AutoResponse;
import com.envoy.biz.service.HandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shizi
 * @since 2022-06-14 20:39:28
 */
@AutoResponse
@RequestMapping("/api/e")
@RestController
public class FrontController {

    @Autowired
    private HandlerService handlerService;

    @GetMapping("de/{haveMysql}")
    public String de(@PathVariable("haveMysql") Boolean haveMysql) {
        return handlerService.de(haveMysql);
    }

    @GetMapping("be/{haveMysql}")
    public String be(@PathVariable("haveMysql") Boolean haveMysql) {
        return handlerService.be(haveMysql);
    }
}
