package com.prata.venda.product.application.repository;

import com.prata.venda.product.domain.Product;

public interface ProductRepository {
    Product saveProduct(Product product);
}
