package cn.xyuli.cloud.common.exception;

import lombok.Getter;

/**
 * @ClassName ServiceUnknownException
 * @Description TODO 系统未知异常
 * @Author xyuli
 * @Date 2022/3/2 6:50 PM
 * @Version 1.0
 **/
@Getter
public class ServiceUnknownException extends WebException {

    private static final Integer errCode = 500;

    public ServiceUnknownException(String errorMsg) {
        super(errCode, errorMsg);
    }
    public ServiceUnknownException(Throwable errorMsg) {
        super(errCode, errorMsg.getMessage());
    }
}
