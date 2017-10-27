package demo.book.service.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import demo.book.dao.BookDAO;
import demo.book.model.Book;
import demo.book.service.BookService;

public class BookServiceImpl implements BookService {
	
	private BookDAO bookDAO;		
	
	public BookDAO getBooks() {
		return bookDAO;
	}

	
	public void setBooks(BookDAO books) {
		this.bookDAO = books;
	}

	@Override
	public Book getBook(int id) {
		// TODO Auto-generated method stub
		return bookDAO.selectBookById(id);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDAO.selectAllBooks();
	}

	@Override
	public Response addBook(Book book) {
		// TODO Auto-generated method stub
		System.out.println("--- AQUI ESTOY ---");
		System.out.println("BOOK: " + book.toString());
		return Response.ok(book).build();
	}

}
