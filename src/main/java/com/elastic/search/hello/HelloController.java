package com.elastic.search.hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elastic.search.hello.data.dto.HelloCreateRequest;
import com.elastic.search.hello.data.dto.HelloCreateResponse;
import com.elastic.search.hello.service.HelloService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "HelloController")
@RestController
@RequiredArgsConstructor
public class HelloController {
    
    private final HelloService helloService;

    @Operation
    @PostMapping("/hello/v1/create")
    public ResponseEntity<HelloCreateResponse> create(HelloCreateRequest request) {
        return ResponseEntity.ok(helloService.create(request));
    }

}
