package demo.book.dao;

import java.util.ArrayList;
import java.util.List;

import demo.book.model.Book;

public class BookDAO {

	private static List<Book> books = new ArrayList<>();
	
	static {
		Book book1 = new Book(1, "Posesion", "Peter James", "1978", "Desconocida");
		Book book2 = new Book(2, "Ojos de Perro Azul", "Gabriel Garcia Marquez", "1970", "Desconocida");
				
		books.add(book1);
		books.add(book2);
	}
	
	public Book selectBookById(int id) {
		return books.get(id);
	}
	
	public List<Book> selectAllBooks() {
		return books;
	}
}
