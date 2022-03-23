package cn.xyuli.cloud.auth.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.xyuli.cloud.auth.config.TokenConfig;
import cn.xyuli.cloud.auth.service.TokenService;
import cn.xyuli.cloud.common.entity.Token;
import cn.xyuli.cloud.common.entity.User;
import cn.xyuli.cloud.common.util.TokenUtil;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TokenServiceImpl
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/14 6:02 PM
 * @Version 1.0
 **/
@Service
public class TokenServiceImpl implements TokenService {

    @Resource
    private RedissonClient redissonClient;
    @Resource
    private TokenConfig tokenConfig;
    @Resource
    private Snowflake snowflake;

    @Override
    public Token generateToken(User user) {
        Token token = new Token();
        BeanUtils.copyProperties(user,token);
        String tokenStr = IdUtil.randomUUID();
        token.setToken(tokenStr);
        RBucket<Token> bucket = redissonClient.getBucket(TokenUtil.getRedisKey(tokenStr));
        bucket.set(token);
        //是否开启过期时间
        if (tokenConfig.getEnableExpire()){
            bucket.expire(tokenConfig.getExpireMilliseconds(), TimeUnit.MILLISECONDS);
            token.setTokenExpiredDate(new Date(System.currentTimeMillis()+tokenConfig.getExpireMilliseconds()));
        }
        return token;
    }

    @Override
    public Token findToken(String token) {
        RBucket<Token> bucket = redissonClient.getBucket(TokenUtil.getRedisKey(token));
        return bucket.get();
    }

    @Override
    public void remove(String token) {
        redissonClient.getBucket(TokenUtil.getRedisKey(token)).delete();
    }

    @Override
    public Token refresh(User user,Token token) {
        remove(token.getToken());
        return generateToken(user);
    }

}
