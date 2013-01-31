package com.vathanakmao.testproj.sampleapp.gae.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vathanakmao.testproj.sampleapp.gae.dao.BookDao;
import com.vathanakmao.testproj.sampleapp.gae.model.Book;
import com.vathanakmao.testproj.sampleapp.gae.service.BookService;
import com.vathanakmao.testproj.sampleapp.gae.test.helper.EntityHelper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BookServiceTest extends BaseLocalUnitTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookDao     bookDao;

    @Test
    public void testAdd() {
        assertEquals(0, bookDao.findAll().size());

        Book book = EntityHelper.createBook();
        bookService.save(book);

        assertEquals(1, book.getId().intValue());
        assertEquals(1, bookDao.findAll().size());
    }
    
    @Test
    public void deleteNullPrimaryKey() {
        Book book = EntityHelper.createBook();
        bookService.save(book);
        assertNotNull(book.getId());
        
        book.setId(null);
        bookService.delete(book);
        
    }
}
