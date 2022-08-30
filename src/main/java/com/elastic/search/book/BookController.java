package com.elastic.search.book;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elastic.search.book.data.dto.BookCreateRequest;
import com.elastic.search.book.data.dto.BookResponse;
import com.elastic.search.book.service.BookService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(name = "엘라스틱서치 책 검색 API")
@RestController
@RequestMapping("/book/")
@RequiredArgsConstructor
public class BookController {
    
    private final BookService bookService;

    @GetMapping("/search")
    public ResponseEntity<List<BookResponse>> search(@RequestParam String keyword) {
        log.info("keyword:{}", keyword);
        return ResponseEntity.ok(bookService.search(keyword));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> select(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.select(id));
    }

    @PostMapping("/create")
    public ResponseEntity<BookResponse> select(@RequestBody BookCreateRequest request) {
        return ResponseEntity.ok(bookService.create(request));
    }
}
