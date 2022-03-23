package cn.xyuli.cloud.gateway.filter;

import cn.hutool.json.JSONUtil;
import cn.xyuli.cloud.cache.conf.RedissonConfig;
import cn.xyuli.cloud.common.entity.Token;
import cn.xyuli.cloud.common.util.TokenUtil;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @ClassName AuthFilter
 * @Description TODO 映射token用户数据过滤器
 * @Author xyuli
 * @Date 2022/3/17 6:31 PM
 * @Version 1.0
 **/
@Component
public class AuthFilter implements GlobalFilter, Ordered {

    @Resource
    private RedissonClient redissonClient;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String token = request.getHeaders().getFirst(TokenUtil.getTokenHeaderKey());
        if (token != null){
            RBucket<Token> bucket = redissonClient.getBucket(TokenUtil.getRedisKey(token.replace("Bearer ","")));
            ServerHttpRequest userInfo = exchange.getRequest().mutate().header("userInfo", JSONUtil.toJsonStr(bucket.get())).build();
            return chain.filter(exchange.mutate().request(userInfo).build());
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 11;
    }
}
