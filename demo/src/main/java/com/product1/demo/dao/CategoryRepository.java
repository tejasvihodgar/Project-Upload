package com.product1.demo.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product1.demo.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Page<Category> findAll(Pageable pageable) ;
		
		
	

	public Optional<Category> findById(Long id) ;
		// TODO Auto-generated method stub
		
	

	public Category save(Category category);
		// TODO Auto-generated method stub
	
	

	public void deleteById(Long id);
		// TODO Auto-generated method stub
		
	

}
