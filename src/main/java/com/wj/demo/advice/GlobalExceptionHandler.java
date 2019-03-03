package com.wj.demo.advice;

import com.alibaba.fastjson.JSON;
import com.wj.demo.base.Response;
import com.wj.demo.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.servlet.http.HttpServletRequest;

/**
 * @describe: 全局异常处理
 * @author: zhuchunwang
 * @date: 2018/5/29 17:40
 * @version: 1.0
 */
@ControllerAdvice(annotations = {RestController.class})
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 默认未知异常
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        e.printStackTrace();
        Response baseView;

        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            baseView = new Response(apiException.getCode(), apiException.getMsg(), null);
        } else {
            baseView = new Response("0", "系统繁忙，请稍后再试", null);
        }
        printLog(request, e, baseView);
        return baseView;
    }

    /**
     * 参数异常
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = {HttpMessageNotReadableException.class, MissingServletRequestPartException.class, MissingServletRequestParameterException.class, MultipartException.class})
    @ResponseBody
    public Response httpMessageNotReadableExceptionErrorHandler(HttpServletRequest request, Exception e) throws Exception {
//        Response baseView = new Response(CodeConstants.PARAMETER_ERROR, CodeConstants.PARAMETER_ERROR_MSG);
        Response baseView = new Response(e.getMessage());
        printLog(request, e, baseView);
        return baseView;
    }

    /**
     * contentType异常
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = {HttpMediaTypeNotSupportedException.class})
    @ResponseBody
    public Response httpMediaTypeNotSupportedExceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        Response baseView = new Response("程序出现异常3");
        printLog(request, e, baseView);
        return baseView;
    }

    /**
     * 异常信息打印日志
     *
     * @param request
     * @param e
     * @param baseView
     */
    private void printLog(HttpServletRequest request, Exception e, Response baseView) {
        logger.error(e.getMessage());
//        logger.error(AppUtil.getExceptionDetail(e));
        LogEntity logEntity = new LogEntity();
        logEntity.setHttpMethod(request.getMethod());
        logEntity.setUrl(request.getRequestURL().toString());
        logEntity.setIp(request.getRemoteAddr());
//        logEntity.setArgs(AppUtil.getRequestBody(request));
        logEntity.setLogType(AppConstants.LOG_TYPE_HTTP);
        logEntity.setReqParams(JSON.toJSONString(request.getParameterMap()));
        logEntity.setRespParams(JSON.toJSONString(baseView));
        logger.error(">>>" + JSON.toJSONString(logEntity));
    }

}