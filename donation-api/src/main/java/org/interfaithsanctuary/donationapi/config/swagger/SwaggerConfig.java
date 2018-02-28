package org.interfaithsanctuary.donationapi.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket documentApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(ApiHelper.ApiInfo())
                .select()
                .paths(regex("/.*"))
                .build();
    }
}
