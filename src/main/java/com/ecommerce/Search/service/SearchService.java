package com.ecommerce.Search.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecommerce.Search.beans.Products;

@Service
public class SearchService {
	
	private List<Products> product;
	
	public SearchService() {
		
		product = new ArrayList<Products>();
		
		product.add(new Products(1,"Moisturizer","Skincare product","Skincare"));
		product.add(new Products(2,"Anti Aging Cream","Skincare product","Skincare"));
		product.add(new Products(3,"Conditioner","Haircare product","Haircare"));
		product.add(new Products(4,"Serum","Haircare product","Haircare"));
		product.add(new Products(5,"Conditioner","Haircare product","Makeup"));
		product.add(new Products(6,"Serum","Haircare product","Makeup"));
		
	}
		
				 
   public List<Products> getProductsByCategory(String category) {
		
		List<Products> result = null;
		
		result = product.stream().filter(products -> category.equalsIgnoreCase(products.getCategory()))
				.collect(Collectors.toList());
		
		return result;
			
	}
   
   public Products getProduct(String productName) {
	   
	   Products p = product.stream().filter(products->productName.equalsIgnoreCase(products.getName()))
			   .findAny()
			   .orElse(null);
	return p;
	   
	   
   }
   
   public List<Products> getAllProducts(){
	return product;
	   
   }
 }



	
	
	
	
	
	
	
	
	
	
	
	
	
	


