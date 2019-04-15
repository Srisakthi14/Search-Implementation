package com.ecommerce.Search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Search.beans.Products;
import com.ecommerce.Search.service.SearchService;

@RestController
@RequestMapping("/api")
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@GetMapping("/search/category/{category}")
	public List<Products> searchProduct(@PathVariable("category") String Category) {
		
		List<Products> result = searchService.getProductsByCategory(Category);
		
		if(result == null) {
			throw new CustomException("No Results Found");
		}
				return result;
		
	}
	
	@GetMapping("/search/product/{product}")
	public Products getProduct(@PathVariable("product") String productName) {
		
		Products result = searchService.getProduct(productName);
		
		if(result == null) {
			throw new CustomException("No Results Found");
		}
				return result;
		
	}
	
	@GetMapping("/search")
	public List<Products> getAllProducts(){
		
		List<Products> result = searchService.getAllProducts();
		return result;
		
	}

}
