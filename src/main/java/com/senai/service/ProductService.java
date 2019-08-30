package com.senai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senai.model.Product;
import com.senai.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	
	public List<Product> findAll(){
		return repo.findAll();
	}
	
	public Product find(int id){
		return repo.findById(id).get();
	}
	
	public Product save(Product product) {
		return repo.save(product);
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
}
