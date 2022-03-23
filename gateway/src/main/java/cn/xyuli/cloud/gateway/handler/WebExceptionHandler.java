package cn.xyuli.cloud.gateway.handler;

import cn.xyuli.cloud.common.enums.HttpStatus;
import cn.xyuli.cloud.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName WebExceptionHandler
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/9 4:30 PM
 * @Version 1.0
 **/
@Slf4j
@Order(-1)
@Component
public class WebExceptionHandler implements ErrorWebExceptionHandler {
    @Resource
    private ServerCodecConfigurer serverCodecConfigurer;
    @Resource
    private ObjectProvider<List<ViewResolver>> viewResolversProvider;
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        //判断请求是否执行完成
        if (exchange.getResponse().isCommitted()){
            return Mono.error(ex);
        }
        ServerHttpRequest request = exchange.getRequest();

        R responseMsg = buildResponseMsg(ex);
        log.warn("IP：{}请求:{}时，发生错误，错误原因：{}",request.getLocalAddress().getHostName(),request.getURI().getPath(),responseMsg);

        ServerRequest newRequest = ServerRequest.create(exchange, serverCodecConfigurer.getReaders());
        return RouterFunctions.route(RequestPredicates.all(), serverRequest ->
                        ServerResponse.status(responseMsg.getCode())
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromValue(responseMsg)))
                .route(newRequest)
                .switchIfEmpty(Mono.error(ex))
                .flatMap(handle -> handle.handle(newRequest))
                .flatMap(response -> {
                    ServerHttpResponse res = exchange.getResponse();
                    res.getHeaders().setContentType(response.headers().getContentType());
                    return response.writeTo(exchange, new ServerResponse.Context() {
                        @Override
                        public List<HttpMessageWriter<?>> messageWriters() {
                            return serverCodecConfigurer.getWriters();
                        }

                        @Override
                        public List<ViewResolver> viewResolvers() {
                            return viewResolversProvider.getIfAvailable(Collections::emptyList);
                        }
                    });
                });
    }

    private R buildResponseMsg(Throwable ex){
        if (ex instanceof ResponseStatusException){
            ResponseStatusException responseStatusException = (ResponseStatusException) ex;
            HttpStatus httpStatus = HttpStatus.resolve(responseStatusException.getStatus().value());
            return R.build(httpStatus);
        }
        return null;
    }

}
