/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.apricot.clj.cashierprod.web.controller;


import com.apricot.framework.core.utils.LogUtil;
import com.apricot.framework.web.BaseController;
import com.apricot.framework.web.domain.ApiResponse;
import com.apricot.clj.cashierprod.web.service.DefaultApiInvokeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author wujn
 * @version GatewayController.java, v 0.1 2018-08-29 11:34
 */
@RestController
@Slf4j
public class GatewayController extends BaseController {

    @Autowired
    private DefaultApiInvokeService defaultApiInvokeService;

    @PostMapping("/gateway")
    public ApiResponse gateway(
            @RequestParam(value = "appid") String appId,
            @RequestParam(value = "method") String method,
            @RequestParam(value = "sign") String sign,
            @RequestParam(value = "version") String version,
            @RequestParam(value = "content") String content,
            HttpServletRequest request) throws Throwable {
        Map<String, Object> parameters = WebUtils.getParametersStartingWith(request, "");
        LogUtil.info(log, "【API请求参数】 param={}", parameters);
        Object result = defaultApiInvokeService.invoke(appId, sign, method, parameters, content);
        LogUtil.info(log, "【API请求响应】 param={},result={}", parameters, result);
        return success(result);
    }
}
