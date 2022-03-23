package cn.xyuli.cloud.cache.conf;

import cn.hutool.core.util.StrUtil;
import cn.xyuli.cloud.cache.event.RedisExpiredEventListener;
import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RedissonConfig
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/3 3:27 PM
 * @Version 1.0
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "redisson")
public class RedissonConfig {
    private String host;
    private String pwd;
    private Integer database;
    private Integer timeOut;
    private Integer threads;
    private Integer nettyThreads;
    private String notifyExpiredEventKeyPrefix;


    public static RedissonClient redissonClient;


    @Bean(name = "redissonClient")
    public RedissonClient getRedissonClient(){
        Config config = new Config();
        config.setThreads(threads)
                .setNettyThreads(nettyThreads);
        config.useSingleServer()
                .setAddress("redis://" + host)
                .setDatabase(database)
                .setTimeout(timeOut);
        if (!StrUtil.isBlankIfStr(pwd)){
            config.useSingleServer().setPassword(pwd);
        }
        config.setCodec(new JsonJacksonCodec());
        redissonClient = Redisson.create(config);
        return redissonClient;
    }

    @Bean(name = "rTopic")
    public RTopic getRTopic(){
        RTopic topic = redissonClient.getTopic("__keyevent@" + database + "__:expired");
        topic.addListener(String.class,new RedisExpiredEventListener());
        return topic;
    }

}
