package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.config.AppConfig;
import app.entity.book.Book;
import app.entity.book.Books;
import app.entity.user.User;
import app.entity.user.UserServiceTestIoc;

@RestController()
@RequestMapping("/book")
public class BookController {
	@Autowired
	Book book;
	@Autowired
	Books books;
	
	@GetMapping("/details")
	public String getBook() {
		return book.toString();
	}
	
	@GetMapping("allbooks")
	public List<Book> getBooks(){
		return books.getBooks();
	}
	
	@GetMapping("/beans")
	public String getBeans() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		String res = ctx.getBean(Book.class).toString() + "\n" + ctx.getBean(Books.class).toString() + "\n" + ctx.getBean(User.class).toString();
		((ConfigurableApplicationContext) ctx).close();
		
		return res;
	}
	
	@GetMapping("filter")
	public String testFilter() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBean(UserServiceTestIoc.class).printUser(ctx.getBean(User.class));
		((ConfigurableApplicationContext) ctx).close();
		
		return "What the fuck.";
	}
}
