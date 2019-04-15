package com.ecommerce.Search.beans;

public class Products {
	
	private int id;
	private String name;
	private String description;
	private String category;
	//private List<Products> product;
	
	
	public Products() {
	
	}
	
	
	public Products(int id, String name, String description,String category ) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.category= category;
		
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

	
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
	

}
