package cn.xyuli.cloud.web.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
@EnableConfigurationProperties(value = WebRequestUriConfig.class)
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private WebRequestUriConfig webRequestUriConfig;

	 /**
     * 注册自定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new WebRequestInterceptor());
        WebRequestUriConfig.RequestUri white = webRequestUriConfig.getWhite();
        if (white.getEnable()){
            interceptorRegistration.excludePathPatterns(white.getUri());
        }
        registry.addInterceptor(new GlobalInterceptor()).addPathPatterns("/**");
    }
 }