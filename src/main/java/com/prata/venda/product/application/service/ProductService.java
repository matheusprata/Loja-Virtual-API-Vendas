package com.prata.venda.product.application.service;

import com.prata.venda.product.application.api.*;
import java.util.List;

public interface ProductService {
    ProductIdResponse saveProdutc(ProductRequest productRequest);
    List<ProductListResponse> getAllProducts();
    ProductResponse getById(Long id);
    void updateProduct(Long id, ProductAlteracaoRequest productAlteracaoRequest);
}