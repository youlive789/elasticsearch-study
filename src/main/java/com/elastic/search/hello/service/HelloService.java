package com.elastic.search.hello.service;

import com.elastic.search.hello.data.dto.HelloCreateRequest;
import com.elastic.search.hello.data.dto.HelloCreateResponse;

public interface HelloService {
    public HelloCreateResponse create(HelloCreateRequest request);
}
