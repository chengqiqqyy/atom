package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import app.entity.Product;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@GetMapping
	public String index() {
		return "admin/index";
	}
	
	@GetMapping("/products")
	public ModelAndView productList() {
		ModelAndView mav = new ModelAndView();
		Product item = new Product();
		item.setId(1l);
		item.setName("Apple");
		item.setModel("Fuji");
		item.setCode("A10001");
		item.setPrice(100);
		item.setStock(1000);
		mav.addObject("products",item);
		mav.setViewName("admin/product/adminProductList");
		return mav;
	}
	
	@GetMapping("/product/new")
	public String addProduct() {
		return "admin/product/adminEditProduct";
	}
}
