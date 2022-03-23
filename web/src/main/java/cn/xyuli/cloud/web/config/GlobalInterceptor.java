package cn.xyuli.cloud.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName GlobalInterceptor
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/23 5:33 PM
 * @Version 1.0
 **/
@Slf4j
@Component
public class GlobalInterceptor implements HandlerInterceptor {
    private long startTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        startTime = System.currentTimeMillis();
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long intervalTime = System.currentTimeMillis() - startTime;
        if (intervalTime < 500){
            log.debug("当前请求{},业务处理时间为：{}",request.getRequestURL(),intervalTime);
        }else if (intervalTime < 1000){
            log.info("当前请求{},业务处理时间为：{}",request.getRequestURL(),intervalTime);
        }else if (intervalTime < 1500){
            log.warn("当前请求{},业务处理时间为：{}",request.getRequestURL(),intervalTime);
        }else {
            log.error("当前请求{},业务处理时间为：{}",request.getRequestURL(),intervalTime);
        }
        return;
    }
}
