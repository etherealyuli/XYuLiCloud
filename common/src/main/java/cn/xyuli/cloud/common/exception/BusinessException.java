package cn.xyuli.cloud.common.exception;

import lombok.Getter;

/**
 * @ClassName BusinessException
 * @Description TODO 业务异常
 * @Author xyuli
 * @Date 2022/3/2 6:48 PM
 * @Version 1.0
 **/
@Getter
public class BusinessException extends WebException {

    private static final Integer errCode = 500;

    public BusinessException(String errorMsg) {
        super(errCode, errorMsg);
    }


}
