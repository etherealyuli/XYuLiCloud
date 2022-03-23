package cn.xyuli.cloud.web.util;

import cn.xyuli.cloud.common.entity.Token;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
* @ClassName WebServerThreadLocal
* @Description TODO WebServerThreadLocal
* @Author xyuli
* @Date 2022/3/16 12:10 PM
* @Version 1.0
**/
@Component
public class WebServerThreadLocal{

    public static ThreadLocal<WebServerThreadLocal.WebServerThreadLocalBo> webServerThreadLocalBoThreadLocal = new ThreadLocal<>();

    public static void setToken(Token token){
        initWebServerThreadLocalBo();
        WebServerThreadLocalBo webServerThreadLocalBo = webServerThreadLocalBoThreadLocal.get();
        webServerThreadLocalBo.setToken(token);
    }
    public static Token getToken(){
        WebServerThreadLocalBo webServerThreadLocalBo = webServerThreadLocalBoThreadLocal.get();
        return webServerThreadLocalBo.getToken();
    }

    public static void initWebServerThreadLocalBo(){
        WebServerThreadLocalBo webServerThreadLocalBo = webServerThreadLocalBoThreadLocal.get();
        if (webServerThreadLocalBo == null){
            webServerThreadLocalBoThreadLocal.set(new WebServerThreadLocalBo());
        }
    }

    @Data
    public static class WebServerThreadLocalBo{
        private Token token;
    }
}
