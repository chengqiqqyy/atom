package app.entity.book;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix="book")
@Data
public class Book {
	private String name;
	private int price;
	private String[] hobby;
}
