package app.mapper;

import org.apache.ibatis.annotations.Mapper;

import app.entity.Product;

@Mapper
public interface ProductMapper extends BaseMapper<Product>{
	
}
