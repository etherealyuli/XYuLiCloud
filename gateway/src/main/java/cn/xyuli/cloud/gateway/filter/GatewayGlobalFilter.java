package cn.xyuli.cloud.gateway.filter;

import cn.xyuli.cloud.common.util.TokenUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * @author yulichen
 * @version 1.0
 * @description: TODO 网关全局拦截器
 * @date 2021/12/11 3:55 下午
 */
@Component
public class GatewayGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String token = request.getHeaders().getFirst(TokenUtil.getTokenHeaderKey());
        if (token != null){

        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -10;
    }
}