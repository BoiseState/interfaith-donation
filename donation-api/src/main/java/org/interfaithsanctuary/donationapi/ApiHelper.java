package org.interfaithsanctuary.donationapi;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

public class ApiHelper {
    public static ApiInfo ApiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger Documentation")
                .description("API Documentation")
                .version("2.0")
                .build();
    }
}
