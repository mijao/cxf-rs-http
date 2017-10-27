package demo.book.service.impl;

import java.util.List;

import demo.book.dao.BookDAO;
import demo.book.model.Book;
import demo.book.service.BookService;

public class BookServiceImpl implements BookService {
	
	private BookDAO books = new BookDAO();

	@Override
	public Book getBook(int id) {
		// TODO Auto-generated method stub
		return books.selectBookById(id);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return books.selectAllBooks();
	}

}
