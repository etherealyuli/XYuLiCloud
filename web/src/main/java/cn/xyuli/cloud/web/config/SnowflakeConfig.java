package cn.xyuli.cloud.web.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName SnowflakeConfig
 * @Description TODO 雪花算法Id生成器
 * @Author xyuli
 * @Date 2022/3/16 10:45 AM
 * @Version 1.0
 **/
@Component
public class SnowflakeConfig {

    private static Snowflake snowflake;

    @Bean(name = "snowflake")
    public Snowflake snowflake(){
        snowflake = IdUtil.getSnowflake(NetUtil.ipv4ToLong(NetUtil.getLocalhostStr())%32);
        return snowflake;
    }

    public static String nextId(){
        return snowflake.nextIdStr();
    }

}
