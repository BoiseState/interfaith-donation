package org.interfaithsanctuary.donationapi;

import org.interfaithsanctuary.donationapi.controller.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@Configuration
@EnableSwagger2
public class DonationApiApplication extends SpringBootServletInitializer {

	@Bean
	public HomeController homeController() { return new HomeController(); }

	public static void main(String[] args) {
		SpringApplication.run(DonationApiApplication.class, args);
	}

	@Bean
	public Docket documentApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(ApiHelper.ApiInfo())
				.select()
				.paths(regex("/.*"))
				.build();
	}
}
