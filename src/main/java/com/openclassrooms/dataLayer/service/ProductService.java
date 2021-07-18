package com.openclassrooms.dataLayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.dataLayer.model.Product;
import com.openclassrooms.dataLayer.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Iterable<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public Optional<Product> getProductById(Integer id){
		return productRepository.findById(id);
	}
	
	public Iterable<Product> getProductsByName(String name) {
		return productRepository.findByName(name);
	}
	
	public Iterable<Product> getProductByCategoryName(String name) {
		return productRepository.findByCategoriesName(name);
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product) ;		
	}
	
	public void deleteProductById(Integer id) {
		 productRepository.deleteById(id);
	}
	
	
	public Iterable<Product> getProductsByCostLessThan(Integer cost){
		return productRepository.findByCostLessThan(cost);
	}

}
