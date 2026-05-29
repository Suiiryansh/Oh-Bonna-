package com.ecommerce.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.entity.Category;
import com.ecommerce.ecommerce.repository.CategoryRepository;
import com.ecommerce.ecommerce.repository.ProductRepository;

@Service
public class CategoryService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
    this.categoryRepository = categoryRepository;
    this.productRepository = productRepository;
}

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
    return categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category updateCategory(Long id, Category updatedCategory) {

    Category existing = categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Category not found"));

    existing.setName(updatedCategory.getName());
    existing.setDescription(updatedCategory.getDescription());

    return categoryRepository.save(existing);
    }

    public List<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }

    public void deleteCategory(Long id) {
    boolean hasProducts = productRepository.existsByCategoryId(id);

    if (hasProducts) {
        throw new RuntimeException("Cannot delete category with products");
    }

    categoryRepository.deleteById(id);
}    
}