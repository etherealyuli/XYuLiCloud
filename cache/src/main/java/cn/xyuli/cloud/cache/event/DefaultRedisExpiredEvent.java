package cn.xyuli.cloud.cache.event;

import cn.xyuli.cloud.cache.annotation.RedisKeyPrefix;
import org.springframework.stereotype.Component;

/**
 * @ClassName DefaultRedisExpiredEvent
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/14 3:36 PM
 * @Version 1.0
 **/
@Component
@RedisKeyPrefix("cn.xyuli")
public class DefaultRedisExpiredEvent implements IRedisExpiredEvent{
    @Override
    public void action(String key) {

    }
}
