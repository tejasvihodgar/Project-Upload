package com.product1.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import com.product1.demo.dao.CategoryRepository;
import com.product1.demo.entity.Category;
@Service
public class CategoryService {
	@Autowired
    private CategoryRepository categoryRepository;
	
	public Page<Category> getAllCategories(int page , int size) {
		Pageable pageable  = PageRequest.of(page, size);
		 return categoryRepository.findAll(pageable);
		}
	public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category categoryDetails) {
//        return categoryRepository.findById(id).map(existingCategory -> {
//            existingCategory.setName(category.getName());
//            return categoryRepository.save(existingCategory);
//        }).orElseThrow(() -> new RuntimeException("Category not found"));
    	Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    	category.setName(categoryDetails.getName());
    	return categoryRepository.save(category);

    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
	

}

