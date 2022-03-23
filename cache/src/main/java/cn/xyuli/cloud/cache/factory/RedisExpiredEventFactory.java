package cn.xyuli.cloud.cache.factory;

import cn.xyuli.cloud.cache.event.IRedisExpiredEvent;
import cn.xyuli.cloud.cache.annotation.RedisKeyPrefix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RedisExpiredFactory
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/3 5:08 PM
 * @Version 1.0
 **/
@Slf4j
@Component
public class RedisExpiredEventFactory {

    @Resource
    private List<IRedisExpiredEvent> iRedisExpiredEvents;

    /**
     * Redis过期事件map
     */
    public static final Map<String, IRedisExpiredEvent> REDIS_EXPIRED_EVENT_MAP = new HashMap<>();

    @PostConstruct
    public void registerRedisExpiredEvent(){
        for (int i = 0; i < iRedisExpiredEvents.size(); i++) {
            IRedisExpiredEvent iRedisExpiredEvent = iRedisExpiredEvents.get(i);
            RedisKeyPrefix iRedisExpiredEventAnnotation = iRedisExpiredEvent.getClass().getAnnotation(RedisKeyPrefix.class);
            if (iRedisExpiredEventAnnotation == null){
                throw new RuntimeException("未在此"+iRedisExpiredEvent.getClass().getName()+",redis事件中找到RedisKeyPrefix");
            }

            iRedisExpiredEvents.forEach(redisExpiredEvents ->{
                RedisKeyPrefix redisExpiredEventsAnnotation = redisExpiredEvents.getClass().getAnnotation(RedisKeyPrefix.class);
                if (redisExpiredEventsAnnotation == null){
                    throw new RuntimeException("未在此"+redisExpiredEvents.getClass().getName()+",redis事件中找到RedisKeyPrefix");
                }

                if (iRedisExpiredEvent != redisExpiredEvents && iRedisExpiredEventAnnotation.value().contains(redisExpiredEventsAnnotation.value())){
                    throw new RuntimeException("Redis注册事件冲突:"+iRedisExpiredEventAnnotation.value()+"->"+iRedisExpiredEvent.getClass().getName()+"与"+redisExpiredEventsAnnotation.value()+"->"+redisExpiredEvents.getClass().getName()+"冲突"+redisExpiredEvents.getClass().getName());
                }
            });
            REDIS_EXPIRED_EVENT_MAP.put(iRedisExpiredEventAnnotation.value(),iRedisExpiredEvent);
        }
    }



    public static IRedisExpiredEvent getRedisExpiredEvent(String prefix){
        return REDIS_EXPIRED_EVENT_MAP.get(prefix);
    }

}
