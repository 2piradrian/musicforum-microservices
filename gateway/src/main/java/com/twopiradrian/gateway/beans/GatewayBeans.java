package com.twopiradrian.gateway.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayBeans {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r
                        .path("/api/forum/**")
                        .filters(f -> f.rewritePath("/api/forum/(?<segment>.*)", "/forum-server/api/forum/${segment}"))
                        .uri("lb://forum-server")
                )
                .route(r -> r
                        .path("/api/comment/**")
                        .filters(f -> f.rewritePath("/api/comment/(?<segment>.*)", "/forum-server/api/comment/${segment}"))
                        .uri("lb://forum-server")
                )
                .route(r -> r
                        .path("/api/users/**")
                        .filters(f -> f.rewritePath("/api/users/(?<segment>.*)", "/auth-server/api/users/${segment}"))
                        .uri("lb://auth-server")
                )
                .route(r -> r
                        .path("/api/report/**")
                        .filters(f -> f.rewritePath("/api/report/(?<segment>.*)", "/report-server/api/report/${segment}"))
                        .uri("lb://report-server")
                )
                .build();
    }

}
