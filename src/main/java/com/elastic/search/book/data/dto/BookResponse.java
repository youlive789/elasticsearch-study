package com.elastic.search.book.data.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {
    private String title;
    private String publisher;
    private String ISBN;
    private Date releaseDate;
    private String description;
}
