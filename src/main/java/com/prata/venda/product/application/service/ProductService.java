package com.prata.venda.product.application.service;

import com.prata.venda.product.application.api.ProductIdResponse;
import com.prata.venda.product.application.api.ProductListResponse;
import com.prata.venda.product.application.api.ProductRequest;

import java.util.List;

public interface ProductService {
    ProductIdResponse saveProdutc(ProductRequest productRequest);
    List<ProductListResponse> getAllProducts();
}