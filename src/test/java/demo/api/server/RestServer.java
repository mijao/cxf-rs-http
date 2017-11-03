package demo.api.server;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.api.service.BookService;
import demo.api.service.impl.BookServiceImpl;

public class RestServer {
	
	private static Server server;
	
	public static void runServer() throws Exception {
				
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/beans.xml");		
		
	    //JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
		JAXRSServerFactoryBean factoryBean = (JAXRSServerFactoryBean) context.getBean("exampleCxfServer");
	    /*factoryBean.setResourceClasses(BookServiceImpl.class);
	    factoryBean.setResourceProvider(new SingletonResourceProvider(new BookServiceImpl()));*/
	    factoryBean.setAddress("http://localhost:8080/");
	    server = factoryBean.create();
	
	    System.out.println("Server ready...");
	    //Thread.sleep(60 * 1000);
	    //System.out.println("Server exiting");
	    //server.destroy();
	    //System.exit(0);		
	}
	
	public static void destroyServer() throws Exception {		
	    System.out.println("Server exiting");
	    server.destroy();	    	    
	}	
}
