package demo.api.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.api.model.Book;

public class BookDAO {

	//private static List<Book> books = new ArrayList<>();
	private static Map<Integer, Book> books = new HashMap<Integer, Book>();
	
	static {
		Book book1 = new Book(1, "Posesion", "Peter James", "1978", "Desconocida");
		Book book2 = new Book(2, "Ojos de Perro Azul", "Gabriel Garcia Marquez", "1970", "Desconocida");
				
		books.put(book1.getId(), book1);
		books.put(book2.getId(), book2);
	}
	
	public Book selectBookById(int id) {
		return books.get(id);
	}
	
	public Collection<Book> selectAllBooks() {						
		return books.values();
	}
	
	public void insertBook(Book book) {
		books.put(book.getId(), book);		
	}
}
