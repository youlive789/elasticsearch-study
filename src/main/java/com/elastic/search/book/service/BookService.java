package com.elastic.search.book.service;

import java.util.List;

import com.elastic.search.book.data.dto.BookCreateRequest;
import com.elastic.search.book.data.dto.BookResponse;

public interface BookService {
    public List<BookResponse> search(String keyword);
    public BookResponse create(BookCreateRequest request);
    public BookResponse select(Long id);
}
