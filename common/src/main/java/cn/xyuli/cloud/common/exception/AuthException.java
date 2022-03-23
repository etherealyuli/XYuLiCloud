package cn.xyuli.cloud.common.exception;

/**
 * @ClassName AuthException
 * @Description TODO 授权异常
 * @Author xyuli
 * @Date 2022/3/3 2:52 PM
 * @Version 1.0
 **/
public class AuthException extends WebException {
    public AuthException(Integer errCode, String errorMsg) {
        super(errCode, errorMsg);
    }
}
