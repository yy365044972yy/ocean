package com.hb.ocean.handler;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.base.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler extends BaseApiService {
    //全局异常捕获
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public BaseResponse resultError(Exception ex) {

        // 得到异常棧的首个元素
        StackTraceElement stackTraceElement = ex.getStackTrace()[0];
        return setResultError("程序运行错误,文件名:" + stackTraceElement.getFileName() + ",错误行数:" + stackTraceElement.getLineNumber() + ",错误方法:" + stackTraceElement.getMethodName());

    }


}
