package com.nr.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @author：tiger
 * @date：2022/4/13
 */
@Configuration
public class GageWayConfig {

    /**
     * 配置了一个idroute-name的路由规则
     * 当访问地址http://localhost:9527/guonei时，会自动转发到地址：http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_nr",
                        r -> r.path("/guonei")
                             .uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_nr2",
                r -> r.path("/index.html")
                        .uri("https://tieba.baidu.com/index.html")).build();

        return routes.build();
    }
}
