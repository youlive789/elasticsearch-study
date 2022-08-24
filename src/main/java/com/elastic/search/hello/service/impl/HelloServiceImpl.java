package com.elastic.search.hello.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.elastic.search.hello.data.dto.HelloCreateRequest;
import com.elastic.search.hello.data.dto.HelloCreateResponse;
import com.elastic.search.hello.data.entity.Hello;
import com.elastic.search.hello.data.repository.HelloElasticsearchRepository;
import com.elastic.search.hello.service.HelloService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HelloServiceImpl implements HelloService {

    private final ModelMapper modelMapper;
    private final HelloElasticsearchRepository repository;

    @Override
    public HelloCreateResponse create(HelloCreateRequest request) {
        Hello saved = repository.save(modelMapper.map(request, Hello.class));
        return modelMapper.map(saved, HelloCreateResponse.class);
    }
    
}
