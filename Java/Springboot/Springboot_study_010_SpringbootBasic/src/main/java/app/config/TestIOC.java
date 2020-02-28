package app.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.entity.book.Book;
import app.entity.book.Books;
import app.entity.user.User;
import app.entity.user.UserServiceTestIoc;

public class TestIOC {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		User user = ctx.getBean(User.class);
		Book book = ctx.getBean(Book.class);
		Books books = ctx.getBean(Books.class);
		
		// n扫描不到，必须声明在 config 类中
//		System.out.println(ctx.getBean(TestAnnotationBean.class).toString());
		System.out.println(ctx.getBean("getDataSource"));
		ctx.getBean("getDataSource");
		ctx.getBean(UserServiceTestIoc.class).printUser(user);
		
		((ConfigurableApplicationContext) ctx).close();
		
		System.out.println(user);
		System.out.println(book);
		System.out.println(books);
	}
}
