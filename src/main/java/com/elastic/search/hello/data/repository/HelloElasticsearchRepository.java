package com.elastic.search.hello.data.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.elastic.search.hello.data.entity.Hello;

@Repository
public interface HelloElasticsearchRepository extends ElasticsearchRepository<Hello, Long> {
    
}