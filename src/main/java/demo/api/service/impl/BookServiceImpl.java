package demo.api.service.impl;

import java.util.Collection;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import demo.api.dao.BookDAO;
import demo.api.model.Book;
import demo.api.service.BookService;

public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDAO;
			
	public BookServiceImpl() {
		super();
	}

	public BookDAO getBooks() {
		return bookDAO;
	}

	
	public void setBooks(BookDAO books) {
		this.bookDAO = books;
	}

	@Override
	public Book getBook(int id) {		
		return bookDAO.selectBookById(id);
	}

	@Override
	public Collection<Book> getAllBooks() {
		return bookDAO.selectAllBooks();
	}

	@Override
	public Response addBook(Book book) {				
		bookDAO.insertBook(book);		
		return Response.status(201).entity(book).build();
	}

}
