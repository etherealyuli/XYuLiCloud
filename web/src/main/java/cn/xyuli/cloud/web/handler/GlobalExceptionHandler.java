package cn.xyuli.cloud.web.handler;

import cn.xyuli.cloud.common.exception.*;
import cn.xyuli.cloud.common.enums.HttpStatus;
import cn.xyuli.cloud.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @ClassName ExceptionHandler
 * @Description TODO 异常处理器
 * @Author xyuli
 * @Date 2022/3/3 2:40 PM
 * @Version 1.0
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常处理
     * @param businessException 业务异常
     * @return 异常响应报文
     */
    @ExceptionHandler(value = BusinessException.class)
    public R handlerBusinessException(BusinessException businessException){
        log.debug("业务异常：{}",businessException.getMessage());
        return R.build(businessException.getErrCode(),businessException.getMessage());
    }

    /**
     * 授权异常处理
     * @param authException 授权异常
     * @return 异常响应报文
     */
    @ExceptionHandler(value = AuthException.class)
    public R handlerUnauthorizedException(AuthException authException){
        log.debug("授权异常：{}",authException.getMessage());
        return R.build(HttpStatus.valueOf(authException.getErrCode()));
    }
    /**
     * 服务维护或过载异常处理
     * @param serviceUnavailableException 服务维护或过载异常
     * @return 异常响应报文
     */
    @ExceptionHandler(value = ServiceUnavailableException.class)
    public R handlerServiceUnavailableException(ServiceUnavailableException serviceUnavailableException){
        log.debug("服务维护或过载异常处理：{}",serviceUnavailableException.getMessage());
        return R.build(HttpStatus.valueOf(serviceUnavailableException.getErrCode()));
    }

    /**
     * 服务未知异常处理
     * @param serviceUnknownException 服务未知异常
     * @return 异常响应报文
     */
    @ExceptionHandler(value = ServiceUnknownException.class)
    public R handlerServiceUnknownException(ServiceUnknownException serviceUnknownException){
        log.error("服务未知异常：{}",serviceUnknownException.getMessage());
        return R.build(HttpStatus.valueOf(serviceUnknownException.getErrCode()));
    }
    /**
     * 运行异常
     * @param httpMessageNotReadableException 缺少参数异常
     * @return 异常响应报文
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public R handlerServiceUnknownException(HttpMessageNotReadableException httpMessageNotReadableException){
        log.error("缺少请求参数：{}",httpMessageNotReadableException.getMessage());
        httpMessageNotReadableException.printStackTrace();
        return R.build(HttpStatus.BAD_REQUEST);
    }
    /**
     * 参数校验异常
     * @param methodArgumentNotValidException 参数校验异常
     * @return 异常响应报文
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handlerMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        log.error("参数校验失败：{}",methodArgumentNotValidException.getMessage());
        BindingResult result = methodArgumentNotValidException.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuffer sb = new StringBuffer();
        fieldErrors.forEach(fieldError -> {
            sb.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append("\n");
        });
        return R.build(400,sb.toString());
    }
    /**
     * 运行异常
     * @param runtimeException 运行异常
     * @return 异常响应报文
     */
    @ExceptionHandler(value = RuntimeException.class)
    public R handlerServiceUnknownException(RuntimeException runtimeException){
        log.error("运行异常：{}",runtimeException.getMessage());
        runtimeException.printStackTrace();
        return R.failure(runtimeException.getMessage());
    }
    /**
     * 运行异常
     * @param exception 异常
     * @return 异常响应报文
     */
    @ExceptionHandler(value = Exception.class)
    public R handlerServiceUnknownException(Exception exception){
        log.error("异常：{}",exception.getMessage());
        exception.printStackTrace();
        return R.failure(exception.getMessage());
    }

}
