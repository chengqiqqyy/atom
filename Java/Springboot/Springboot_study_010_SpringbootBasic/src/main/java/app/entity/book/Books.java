package app.entity.book;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "booklist")
@Data
public class Books {
	private List<Book> books;
}
