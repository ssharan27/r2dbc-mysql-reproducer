package com.example.router;

import com.example.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class TestRouter {
    @Bean
    public RouterFunction<ServerResponse> routes(TestService testService) {
        return RouterFunctions.route()
            .POST("save", request -> ServerResponse.ok().body(testService.saveTestData(request)))
            .GET("get", request -> ServerResponse.ok().body(testService.getAllTestData()))
            .build();
    }
}
