package app.service;

import java.util.List;

import app.entity.Product;

public interface ProductService {
	List<Product> findAll();
	Product findProductById(Long id);
	List<Product> findProductLikeName(String name);
	int insertProduct(Product product);
	int updateProduct(Product product);
	int deleteProductById(Long id);
}
