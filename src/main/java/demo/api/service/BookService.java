package demo.api.service;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import demo.api.model.Book;

@Path("/books")
@Produces("application/json")
public interface BookService {
	
    @GET
    @Path("/{id}")
    public Book getBook(@PathParam("id") int id);
    
    @GET    
    public Collection<Book> getAllBooks();
    
    @POST    
    @Consumes("application/json")
    public Response addBook(Book book);    

}
