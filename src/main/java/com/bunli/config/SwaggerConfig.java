
package com.bunli.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi foodDeliveryApi() {
        return GroupedOpenApi.builder()
                .group("food-delivery")
                .packagesToScan("com.bunli.controller")
                .build();
    }

    @Bean
    public OpenAPI foodDeliveryOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Food Delivery API")
                        .version("v1")
                        .description("REST API documentation for Food Delivery System"));
    }
}
