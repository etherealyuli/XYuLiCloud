package cn.xyuli.cloud.common.exception;

import lombok.Getter;

/**
 * @ClassName ForbiddenException
 * @Description TODO 暂无权限异常
 * @Author xyuli
 * @Date 2022/3/2 6:51 PM
 * @Version 1.0
 **/
@Getter
public class ForbiddenException extends AuthException{

    private static final Integer errCode = 403;
    private static final String errorMsg = "暂无权限";

    public ForbiddenException() {
        super(errCode, errorMsg);
    }
}
