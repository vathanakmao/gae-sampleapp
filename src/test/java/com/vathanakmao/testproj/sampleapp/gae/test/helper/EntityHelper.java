package com.vathanakmao.testproj.sampleapp.gae.test.helper;

import com.vathanakmao.testproj.sampleapp.gae.model.Book;

public class EntityHelper {

    public static Book createBook() {
	Book book = new Book();
	book.setTitle("Java");
	book.setAuthor("Vathanak Mao");
	book.setPrice(50);
	book.setPublishedYear(2014);
	return book;
    }
}
