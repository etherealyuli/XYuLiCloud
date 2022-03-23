package cn.xyuli.cloud.web.config;

import cn.hutool.json.JSONUtil;
import cn.xyuli.cloud.common.entity.Token;
import cn.xyuli.cloud.common.exception.UnauthorizedException;
import cn.xyuli.cloud.web.util.WebServerContext;
import cn.xyuli.cloud.web.util.WebServerThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yulichen
 * @version 1.0
 * @description: TODO
 * @date 2021/12/30 5:00 下午
 */
@Slf4j
public class WebRequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String userInfo = request.getHeader("userInfo");
        if (userInfo != null){
            WebServerThreadLocal.setToken(JSONUtil.toBean(userInfo, Token.class));
            log.debug(WebServerContext.getToken().toString());
        }else if (!WebServerContext.getNoLoginUrl().contains(requestURI)){
            throw new UnauthorizedException();
        }
        return true;
    }

}
