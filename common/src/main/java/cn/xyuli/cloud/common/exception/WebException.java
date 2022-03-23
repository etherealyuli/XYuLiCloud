package cn.xyuli.cloud.common.exception;

import lombok.Getter;

/**
 * @ClassName BaseException
 * @Description TODO 底层异常
 * @Author xyuli
 * @Date 2022/3/2 6:36 PM
 * @Version 1.0
 **/
@Getter
public class WebException extends RuntimeException{
    private Integer errCode;

    public WebException(Integer errCode){
        this.errCode = errCode;
    }
    public WebException(String errorMsg){
        super(errorMsg);
        this.errCode = 500;
    }
    public WebException(Integer errCode, String errorMsg){
        super(errorMsg);
        this.errCode = errCode;
    }
}
