package cn.xyuli.cloud.common.exception;

import lombok.Getter;

/**
 * @ClassName OAuthException
 * @Description TODO 用户授权异常
 * @Author xyuli
 * @Date 2022/3/2 6:42 PM
 * @Version 1.0
 **/
@Getter
public class UnauthorizedException extends AuthException{

    private static final Integer errCode = 401;
    private static final String errorMsg = "未经授权";

    public UnauthorizedException() {
        super(errCode, errorMsg);
    }
}
