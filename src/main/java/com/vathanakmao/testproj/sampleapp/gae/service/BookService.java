package com.vathanakmao.testproj.sampleapp.gae.service;

import com.vathanakmao.testproj.sampleapp.gae.model.Book;

public interface BookService {
    void save(Book book);

    Book get(Long id);

    void update(Book book);

    void delete(Book book);
}
