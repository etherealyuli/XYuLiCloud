package cn.xyuli.cloud.web.util;

import cn.xyuli.cloud.common.entity.Token;
import cn.xyuli.cloud.web.handler.NoLoginHandler;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @ClassName WebServerContext
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/16 12:10 PM
 * @Version 1.0
 **/
@Component
public class WebServerContext {

    public static Token getToken() {
        return WebServerThreadLocal.getToken();
    }

    public static String getUserId() {
        return WebServerThreadLocal.getToken().getUserId();
    }

    public static Set<String> getNoLoginUrl(){
        return NoLoginHandler.getNoLoginUrlSet();
    }

}
