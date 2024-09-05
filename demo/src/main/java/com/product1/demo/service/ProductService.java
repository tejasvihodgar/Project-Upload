package com.product1.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.product1.demo.dao.ProductRepository;
import com.product1.demo.entity.Product;
@Service
public class ProductService {
	 @Autowired
	    private ProductRepository productRepository;
	
	 
		 public Page<Product> getAllProducts(int page , int size) {
			 Pageable pageable = PageRequest.of(page, size);
		        return productRepository.findAll(pageable);
		    }

		    public Optional<Product> getProductById(Long id) {
		        return productRepository.findById(id);
		    }

		    public Product createProduct(Product product) {
		        return productRepository.save(product);
		    }

		    public Product updateProduct(Long id, Product productDetails) {
		        return productRepository.findById(id).map(existingProduct -> {
		            existingProduct.setName(productDetails.getName());
		            existingProduct.setPrice(productDetails.getPrice());
		            existingProduct.setCategory(productDetails.getCategory());
		            return productRepository.save(existingProduct);
		        }).orElseThrow(() -> new RuntimeException("Product not found"));
		    }

		    public void deleteProduct(Long id) {
		        productRepository.deleteById(id);
		    
		
		
	}

}
