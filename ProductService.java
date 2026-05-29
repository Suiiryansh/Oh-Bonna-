package com.ecommerce.ecommerce.service;
import java.util.List;

import org.springframework.stereotype.Service;
import com.ecommerce.ecommerce.entity.Category;
import com.ecommerce.ecommerce.entity.Product;
import com.ecommerce.ecommerce.repository.CategoryRepository;
import com.ecommerce.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAllProducts() {
    return productRepository.findAll();
    }

    public Product createProduct(Long categoryId, Product product) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
    return productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updateProduct(Long id, Product updatedProduct) {
    Product existing = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));
    existing.setName(updatedProduct.getName());
    existing.setPrice(updatedProduct.getPrice());
    return productRepository.save(existing);
    }

    public void deleteProduct(Long id) {
    productRepository.deleteById(id);
    }
}