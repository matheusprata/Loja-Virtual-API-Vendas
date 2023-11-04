package com.prata.venda.product.application.repository;

import com.prata.venda.product.domain.Product;

import java.util.List;

public interface ProductRepository {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product findById(Long id);
}
