package com.vathanakmao.testproj.sampleapp.gae.dao.impl;

import org.springframework.stereotype.Repository;

import com.vathanakmao.testproj.sampleapp.gae.dao.BookDao;
import com.vathanakmao.testproj.sampleapp.gae.dao.GenericJpaDao;
import com.vathanakmao.testproj.sampleapp.gae.model.Book;

@Repository("bookDao")
public class BookDaoImpl extends GenericJpaDao<Book, Long> implements BookDao {

}
