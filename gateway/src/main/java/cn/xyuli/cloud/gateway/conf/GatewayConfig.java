package cn.xyuli.cloud.gateway.conf;

import lombok.Data;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName BaseConfig
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/8 6:34 PM
 * @Version 1.0
 **/
@Data
//需要加上AutoConfigureAfter以表示在spring-cloud-gateway加载之前先加载云配置，已达到刷新网关路由配置的要求，实现动态路由
@AutoConfigureAfter
@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "spring.cloud.gateway.route.config")
public class GatewayConfig {
    private String group;
}
