package cn.xyuli.cloud.cache.event;

/**
 * @ClassName IRedisExpiredEvent
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/3 6:06 PM
 * @Version 1.0
 **/
public interface IRedisExpiredEvent {
    void action(String key);
}
