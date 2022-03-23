package cn.xyuli.cloud.cache.event;

import cn.xyuli.cloud.cache.conf.RedissonConfig;
import cn.xyuli.cloud.cache.factory.RedisExpiredEventFactory;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RTopic;
import org.redisson.api.listener.MessageListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName RedisExpiredEventListener
 * @Description TODO redis过期事件监听器
 * @Author xyuli
 * @Date 2022/3/3 5:12 PM
 * @Version 1.0
 **/
@Slf4j
@Component
public class RedisExpiredEventListener implements MessageListener {

    @Resource
    private RedissonConfig redissonConfig;

    @Override
    public void onMessage(CharSequence channel, Object msg) {
        String key = (String) msg;
        if (!key.contains(redissonConfig.getNotifyExpiredEventKeyPrefix())){
            return;
        }
        try {
            IRedisExpiredEvent redisExpiredEvent = null;
            //拼接获取每一截的key
            String[] split = key.split(":");
            String prefix = "";
            for (int i = 0; i < split.length; i++) {
                prefix = prefix+split[i]+":";
                redisExpiredEvent = RedisExpiredEventFactory.getRedisExpiredEvent(prefix);
                if (redisExpiredEvent != null){
                    break;
                }
            }
            if (redisExpiredEvent == null){
                log.debug("找不到此redisKey绑定的事件{}",key);
                return;
            }
            redisExpiredEvent.action(key);
        }catch (StringIndexOutOfBoundsException e){
            log.trace("切割字符串失败：",e);
        }
        log.debug("收取到过期的事件:{};" , channel);
        log.debug("过期的key={}",msg);
    }
}
