package demo.book.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import demo.book.model.Book;

@Path("/books")
@Produces("application/json")
public interface BookService {
	
    @GET
    @Path("/{id}")
    public Book getBook(@PathParam("id") int id);
    
    @GET    
    public List<Book> getAllBooks();    

}
