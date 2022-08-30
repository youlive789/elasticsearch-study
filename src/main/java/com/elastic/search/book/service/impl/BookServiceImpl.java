package com.elastic.search.book.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.elastic.search.book.data.dto.BookCreateRequest;
import com.elastic.search.book.data.dto.BookResponse;
import com.elastic.search.book.data.entity.Book;
import com.elastic.search.book.data.repository.BookElasticSearchRepository;
import com.elastic.search.book.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookElasticSearchRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<BookResponse> search(String keyword) {
        List<Book> founds = repository.findByTitleOrDescription(keyword, keyword);
        return founds.stream().map(book -> BookResponse.builder()
                .title(book.getTitle())
                .description(book.getDescription())
                .ISBN(book.getISBN())
                .publisher(book.getPublisher())
                .releaseDate(book.getReleaseDate())
                .build()
        ).collect(Collectors.toList());
    }

    @Override
    public BookResponse create(BookCreateRequest request) {
        Book newBook = modelMapper.map(request, Book.class);
        Book saved = repository.save(newBook);
        return modelMapper.map(saved, BookResponse.class);
    }

    @Override
    public BookResponse select(Long id) {
        Book found = repository.findById(id).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(found, BookResponse.class);
    }
    
}
