package cn.xyuli.cloud.cache.annotation;

import java.lang.annotation.*;

/**
 * @InterfaceName IRedisExpiredEvent
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/3 5:08 PM
 * @Version 1.0
 **/
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface RedisKeyPrefix {
    String value();
}
