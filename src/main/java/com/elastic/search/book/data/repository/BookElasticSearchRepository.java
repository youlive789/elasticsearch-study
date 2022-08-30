package com.elastic.search.book.data.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.elastic.search.book.data.entity.Book;

public interface BookElasticSearchRepository extends ElasticsearchRepository<Book, Long> {
    List<Book> findByTitleOrDescription(String title, String description);
}
