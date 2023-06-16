package com.example.service;

import com.example.entity.Test;
import com.example.repository.TestRepository;
import jakarta.servlet.ServletException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class TestService {
    @Autowired
    private TestRepository testRepository;
    public Mono<List<Test>> getAllTestData() {
       return testRepository.findAll()
           .collectList()
           .doOnNext(tests -> log.info("Found data: {}", tests))
           .doOnError(throwable -> {
               log.error("Error", throwable);
           });
    }

    public Mono<List<Test>> saveTestData(ServerRequest request) throws ServletException, IOException {
        List<Test> testList = request.body(new ParameterizedTypeReference<List<Test>>() {
        });
       return testRepository.saveAll(Flux.fromIterable(testList))
           .collectList()
           .doOnNext(tests -> log.info("Saved data: {}", tests))
           .doOnError(throwable -> {
               log.error("Error", throwable);
           });
    }
}
