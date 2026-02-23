package tn.esprit.apigatewayarcane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayArcaneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayArcaneApplication.class, args);
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("Teams",r->r.path("/Arcane/teams/**")
                        .uri("lb://ARCANE-TEAMS") )
                .route("Products",r->r.path("/api/products/**")
                        .uri("lb://MARKETPLACE-SERVICE") )
                .build();

    }
}
