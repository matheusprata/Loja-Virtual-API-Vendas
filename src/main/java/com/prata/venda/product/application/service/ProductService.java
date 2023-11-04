package com.prata.venda.product.application.service;

import com.prata.venda.product.application.api.ProductIdResponse;
import com.prata.venda.product.application.api.ProductRequest;

public interface ProductService {
    ProductIdResponse saveProdutc(ProductRequest productRequest);
}