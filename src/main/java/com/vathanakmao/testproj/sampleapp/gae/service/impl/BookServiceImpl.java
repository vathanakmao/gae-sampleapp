package com.vathanakmao.testproj.sampleapp.gae.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vathanakmao.testproj.sampleapp.gae.dao.BookDao;
import com.vathanakmao.testproj.sampleapp.gae.model.Book;
import com.vathanakmao.testproj.sampleapp.gae.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void save(Book book) {
	bookDao.save(book);
    }

    @Override
    public Book get(Long id) {
	return bookDao.findById(id);
    }

    @Override
    public void update(Book book) {
	bookDao.update(book);
    }

    @Override
    public void delete(Book book) {
	bookDao.delete(book);
    }

}
