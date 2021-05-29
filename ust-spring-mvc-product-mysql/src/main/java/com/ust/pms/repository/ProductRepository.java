package com.ust.pms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ust.pms.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	public List<Product> findByProductName(String productName);
	public List<Product> findByPriceGreaterThan(int price);
	public List<Product> findByPriceLessThan(int price);	
	public List<Product> findByPriceBetween(int lowerRange,int greaterRange);	

}
