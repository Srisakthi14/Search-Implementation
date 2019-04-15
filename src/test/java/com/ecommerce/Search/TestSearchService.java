package com.ecommerce.Search;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import org.junit.Test;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import com.ecommerce.Search.beans.Products;
import com.ecommerce.Search.service.SearchService;

import static org.mockito.Mockito.when;


public class TestSearchService {
	
	@Mock
	private SearchService searchService;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void getAllProductsTest() {
		
		List<Products> list = new ArrayList<Products>();
        Products p1 = new Products(1, "Moisturizer","Skincare product","Skincare");
        Products p2 = new Products(2, "Conditioner","Haircare product","Haircare");
        Products p3 = new Products(3, "Serum","Haircare product","Makeup");
         
        list.add(p1);
        list.add(p2);
        list.add(p3);
         
        when(searchService.getAllProducts()).thenReturn(list);
        //test
        List<Products> prodList = searchService.getAllProducts();
         
        assertEquals(3, prodList.size());
        
		
	}
	
	@Test
	public void getProductsByCategoryTest() {
		
		List<Products> list = new ArrayList<Products>();
		
        Products p1 = new Products(1, "Moisturizer","Skincare product","Skincare");
        Products p2 = new Products(2, "Conditioner","Haircare product","Skincare");
		
		list.add(p1);
		list.add(p2);
		
		when(searchService.getProductsByCategory("Skincare")).thenReturn(list);
		List<Products> prodList = searchService.getProductsByCategory("Skincare");
		
		assertEquals(2, prodList.size());
		
	}

	@Test
	public void getProductTest() {
		
		when(searchService.getProduct("Conditioner")).thenReturn(new Products(1,"Conditioner","Haircare product","Haircare"));
        
        Products p = searchService.getProduct("Conditioner");
         
        assertEquals("Conditioner", p.getName());
        assertEquals("Haircare product", p.getDescription());
        assertEquals("Haircare", p.getCategory());
		
	}

}
