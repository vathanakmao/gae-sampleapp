package com.vathanakmao.testproj.sampleapp.gae.web.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vathanakmao.testproj.sampleapp.gae.model.Book;
import com.vathanakmao.testproj.sampleapp.gae.service.BookService;
import com.vathanakmao.testproj.sampleapp.gae.util.BindingResultParser;

/**
 * 1. Required libs: javax.validation.validation-api.jar and
 * org.hibernate.hibernate-validator.jar 2. Declare <mvc:annotation-driven/> tag
 * in the context file 3. Annotate @Valid annotation on the parameter object to
 * be validated.
 * 
 * @author vathanak
 * 
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@Valid Book book, BindingResult bindingResult) {

	if (bindingResult.hasErrors()) {
	    return new ResponseEntity<ArrayList<String>>(BindingResultParser.toListOfStrings(bindingResult), HttpStatus.BAD_REQUEST);
	}

	bookService.save(book);
	return new ResponseEntity<Long>(book.getId(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") Long bookId) {
	Book book = bookService.get(bookId);
	return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/addform", method = RequestMethod.GET)
    public String addForm(Model model) {
	return "addBookForm";
    }

}
