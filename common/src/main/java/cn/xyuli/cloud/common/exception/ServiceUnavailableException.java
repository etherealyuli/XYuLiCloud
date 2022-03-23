package cn.xyuli.cloud.common.exception;

import lombok.Getter;

/**
 * @ClassName ServiceUnavailableException
 * @Description TODO 服务暂停异常
 * @Author xyuli
 * @Date 2022/3/16 11:51 AM
 * @Version 1.0
 **/
@Getter
public class ServiceUnavailableException extends WebException{
    public ServiceUnavailableException() {
        super(503, "服务器维护或者过载");
    }
}
