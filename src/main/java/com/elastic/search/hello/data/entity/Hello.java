package com.elastic.search.hello.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(indexName = "hello")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hello {
    @Id
    private Long id;
    private String message;
}
