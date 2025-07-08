package com.bm.ecommerce.repository;

import com.bm.ecommerce.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
    // 🔎 Find products by exact category
    List<Product> findByCategory(String category);

    // 🔍 Find products with name containing a keyword (case-insensitive search)
    List<Product> findByNameContainingIgnoreCase(String keyword);

    // 🧮 Find all products within a price range
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    // 📄 Paginated search by category
    Page<Product> findByCategory(String category, Pageable pageable);

    // ✅ Find all products in stock (stock > 0)
    List<Product> findByStockGreaterThan(int stockThreshold);

    // Optional: search by multiple criteria
    List<Product> findByCategoryAndPriceLessThan(String category, BigDecimal price);

    // Optional: find low stock items
    List<Product> findTop5ByStockLessThanOrderByStockAsc(int threshold);
}