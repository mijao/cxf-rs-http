package demo.api.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;

import demo.api.model.Book;
import demo.api.server.RestServer;


public class BookServiceImplTest {
	
	private static final Logger LOG = Logger.getLogger(BookServiceImplTest.class.getName());
	private static String BASE_URL = "http://localhost:8080/books/";	
	private static Gson gson;
	
	@BeforeClass
	public static void createClient() throws Exception {
		RestServer.runServer();	    
	    gson = new Gson();
	}
	     
	@AfterClass
	public static void closeClient() throws Exception {				
		RestServer.destroyServer();
		//client.close();
	}	
			
    @Test
    public void whenGetValidBook_thenReceiveOKResponse() throws IOException {
    	CloseableHttpClient client = HttpClients.createDefault(); 
        final HttpGet httpGet = new HttpGet(BASE_URL + "1");
        httpGet.setHeader("Accept", "application/json");
        final HttpResponse response = client.execute(httpGet);        

        // GET Body Response
        //HttpEntity entity = response.getEntity();
        //String json = EntityUtils.toString(entity, "UTF-8");
        //System.out.println(json);        
        
        //System.out.println("whenGetValidBook_thenReceiveOKResponse: " + response.getStatusLine().getStatusCode());
        
        //Book book = gson.fromJson(json, Book.class);                
        assertEquals(200, response.getStatusLine().getStatusCode());
        //assertEquals(1, book.getId());        
        
        client.close();
    }
    
    @Test
    public void whenGetInvalidBook_thenReceiveNoContentResponse() throws IOException {
    	CloseableHttpClient client = HttpClients.createDefault();
        final HttpGet httpGet = new HttpGet(BASE_URL + "3");
        httpGet.setHeader("Accept", "application/json");
        final HttpResponse response = client.execute(httpGet);        
                 
        assertNull(response.getEntity());              
        assertEquals(204, response.getStatusLine().getStatusCode());
        
        client.close();
    }
    
    @Test
    public void whenGetAllBook_thenReceiveOKResponse() throws IOException {
    	CloseableHttpClient client = HttpClients.createDefault();
        final HttpGet httpGet = new HttpGet(BASE_URL);
        httpGet.setHeader("Accept", "application/json");
        final HttpResponse response = client.execute(httpGet);                                                 
        
        assertEquals(200, response.getStatusLine().getStatusCode());
        client.close();
    }    
    
    @Test
    public void whenCreatedBook_thenReceiveCreatedResponse() throws IOException {
    	CloseableHttpClient client = HttpClients.createDefault();
    	//HttpClient client = new DefaultHttpClient();
    	final HttpPost httpPost = new HttpPost(BASE_URL);
    	    	
    	/********************************/
    	/**** Uso de la libreria GSON ***/
    	/********************************/
    	/*Book book = new Book(3, "Uno", "Dos", "tres", "cuatro");
    	String jsonInString = gson.toJson(book);
    	StringEntity payload = new StringEntity(jsonInString);
    	httpPost.setEntity(payload);*/
    	
    	final InputStream resourceStream = this.getClass().getClassLoader().getResourceAsStream("book.json");
    	httpPost.setEntity(new InputStreamEntity(resourceStream));    	
    	httpPost.setHeader("Content-Type", "application/json");
    	
    	HttpResponse response = client.execute(httpPost);    	
    	
        assertEquals(201, response.getStatusLine().getStatusCode());
        
        client.close();
    }    
 
}
