package app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Product;
import app.mapper.ProductMapper;
import app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductMapper productMapper;

	@Override
	public List<Product> findAll() {
		return productMapper.findAll();
	}

	@Override
	public Product findProductById(Long id) {
		return productMapper.findById(id);
	}

	@Override
	public List<Product> findProductLikeName(String name) {
		return productMapper.findLikeName("%" + name + "%");
	}

	@Override
	public int insertProduct(Product product) {
		return productMapper.insert(product);
	}

	@Override
	public int updateProduct(Product product) {
		return productMapper.update(product);
	}

	@Override
	public int deleteProductById(Long id) {
		return productMapper.deleteById(id);
	}
	
}
