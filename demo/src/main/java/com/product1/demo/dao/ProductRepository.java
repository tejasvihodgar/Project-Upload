package com.product1.demo.dao;

import org.springframework.stereotype.Repository;

import com.product1.demo.entity.Product;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository

	public interface ProductRepository extends JpaRepository<Product, Long> {
	


	
		
	
}