package com.imooc.firstappdemo.config;

import com.imooc.firstappdemo.domain.User;
import com.imooc.firstappdemo.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * 路由器函数 配置
 */
@Configuration
public class RouterFunctionConfiguration {
    /**
     * Servlet
     * 请求接口：ServletRequest 或者 HttpServletRequest
     * 响应接口：ServletResponse或者HttpServletResponse
     * Spring 5.0 重新定义服务请求和响应接口
     * 请求接口：ServerRequest
     * 响应接口：ServerResponse
     * 即可支持Servlet规范，也可以支持自定义，如Netty（Web Server）
     *
     * 定义GET请求，并且返回所有用户对象 URL：/person/find/all
     * Flux是 0-N 个对象集合
     * Mono是 0-1 个对象集合
     * Reactive 中的Flux或Mono是异步处理
     * Flux或Mono都是Publisher
     * 集合对象基本是同步处理
     */

    public RouterFunctionConfiguration() {
    }

    /**
     * 返回所有用户对象
     * @param userRepository
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository) {
        Collection<User> users = userRepository.findAll();
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request -> {
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux, User.class);
                });
    }

}
