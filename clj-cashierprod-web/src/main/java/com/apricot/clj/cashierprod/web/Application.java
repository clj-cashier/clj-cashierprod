package com.apricot.clj.cashierprod.web;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.apricot.framework.common.enums.CommonErrorEnum;
import com.apricot.framework.common.exception.BaseException;
import com.apricot.framework.core.utils.LogUtil;
import com.apricot.framework.extend.apollo.listener.LoggerLevelConfigChangeListener;
import com.apricot.framework.web.domain.ApiResponse;
import com.apricot.framework.web.exception.ApiInvokeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 交易服务入口
 *
 * @author wujn
 * @version OrderController.java, v 0.1 2018-08-28 10:50
 */
@SpringBootApplication
@ControllerAdvice
@ComponentScans({@ComponentScan("com.apricot.clj.cashierprod"),@ComponentScan("com.apricot.framework.web")})
@DubboComponentScan(basePackages = {"com.apricot.framework.extend.dubbo.filter", "com.apricot.clj.cashierprod.service.client.impl"})
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 全局异常处理
     *
     * @param ex
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResponse defaultExceptionHandler(Exception ex) throws Exception {
        ApiResponse response = new ApiResponse();
        response.setSuccess(false);
        try {
            throw ex;
        }/*捕获其他业务异常并处理*/ catch (HttpRequestMethodNotSupportedException e) {
            response.setErrorCode(CommonErrorEnum.NOT_SUPPORT_METHOD.getValue());
            response.setErrorMsg(CommonErrorEnum.NOT_SUPPORT_METHOD.getName() + ":" + e.getMethod());
        } catch (ApiInvokeException apiex) {
            response.setErrorCode(apiex.getCode());
            response.setErrorMsg(apiex.getMsg());
        } catch (BaseException e) {
            // 捕获常规业务异常
            LogUtil.warn(log, "全局异常处理-常规业务异常：code={},msg={}", e.getCode(), e.getMsg());
            response.setErrorCode(e.getCode());
            response.setErrorMsg(e.getMsg());
        } catch (Exception e) {
            LogUtil.error(log, "全局异常处理-系统异常：msg={}", ex, ex.getMessage());
            response.setErrorCode(CommonErrorEnum.SYS_ERROR.getValue());
            response.setErrorMsg(CommonErrorEnum.SYS_ERROR.getName());
        }
        return response;
    }

    @Bean
    public LoggerLevelConfigChangeListener loggerLevelConfigChangeListener() {
        return new LoggerLevelConfigChangeListener();
    }
}
