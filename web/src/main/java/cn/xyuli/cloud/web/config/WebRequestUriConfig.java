package cn.xyuli.cloud.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @ClassName RequestUriConfig
 * @Description TODO 请求URI配置
 * @Author xyuli
 * @Date 2022/3/23 4:54 PM
 * @Version 1.0
 **/
@Data
@Configuration
@ConfigurationProperties("request.uri")
public class WebRequestUriConfig {

    private RequestUri white;

    @Data
    public static class RequestUri{
        private Boolean enable;
        private String name;
        private List<String> uri;
    }
}
