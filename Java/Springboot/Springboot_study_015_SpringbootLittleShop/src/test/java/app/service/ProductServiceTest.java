package app.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.entity.Product;

@SpringBootTest
public class ProductServiceTest {
	@Autowired
	ProductService productService;
	
	@Test
	public void findAllTest() {
		assertThat(productService.findAll()).matches(p -> p.size() > 0);
	}
	
	@Test
	public void findProductByNameTest() {
		assertThat(productService.findProductLikeName("gt")).matches(p -> p.size() == 0);
	}
	
	@Test
	public void newProdcut() {
		Product p = new Product();
		p.setName("Msi GTX 1060ti");
		p.setModel("GTX 1060ti");
		p.setCode("DC00002");
		p.setPrice(1455);
		p.setStock(100);
		p.setProductTypeId(2l);
		
		assertThat(productService.insertProduct(p)).isEqualByComparingTo(1);
	}
	
	@Test
	public void updateProduct() {
		Product product = productService.findProductById(1l);
		product.setNote("Msi GTX 1060ti Dragon");
		productService.updateProduct(product);
	}
	
	@Test
	public void deleteProductByIdTest() {
		assertThat(productService.deleteProductById(2l)).matches(p -> p == 1);
		Consumer<Integer> pint = a -> System.out.println(a);;
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(1);
		set.add(2);
		set.forEach(x -> pint.accept(x));
		
	}
}
