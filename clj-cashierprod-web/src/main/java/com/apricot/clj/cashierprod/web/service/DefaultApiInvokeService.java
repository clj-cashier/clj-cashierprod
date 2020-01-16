/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.apricot.clj.cashierprod.web.service;

import com.apricot.framework.web.service.AbstractApiInvokeService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wujn
 * @version DefaultApiInvokeService.java, v 0.1 2018-08-29 14:58
 */
@Service
public class DefaultApiInvokeService extends AbstractApiInvokeService {

    @Override
    protected boolean checkPermission(String appId, String apiMethodName) {
        return true;
    }

    @Override
    protected boolean checkSign(Map<String, Object> params, String appId) {
        return true;
    }
}
