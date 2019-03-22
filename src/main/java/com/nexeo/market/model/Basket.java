package com.nexeo.market.model;

import java.util.HashMap;
import java.util.Map;

public class Basket {
	
	private Map<Product, Integer> products;
	
	
	
	public Basket(Map<Product, Integer> products) {
		super();
		this.products = products;
	}

	public Basket() {
		products = new HashMap<Product, Integer>();
	}

	/**
	 * @return the products
	 */
	public Map<Product, Integer> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}
	
	

}
