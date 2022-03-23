package cn.xyuli.cloud.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName TokenConfig
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/16 11:38 AM
 * @Version 1.0
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "token")
public class TokenConfig {
    /**
     * 开启过期时间
     */
    private Boolean enableExpire;
    /**
     * 过期毫秒
     */
    private Long expireMilliseconds;
}
