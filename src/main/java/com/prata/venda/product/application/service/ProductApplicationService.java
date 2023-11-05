package com.prata.venda.product.application.service;

import com.prata.venda.product.application.api.*;
import com.prata.venda.product.application.repository.ProductRepository;
import com.prata.venda.product.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductApplicationService implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductIdResponse saveProdutc(ProductRequest productRequest) {
        log.info("[start] ProductApplicationService - saveProdutc");
        Product product = productRepository.saveProduct(new Product(productRequest));
        log.info("[finish] ProductApplicationService - saveProdutc");
        return ProductIdResponse
                .builder()
                .idProduct(product.getIdProduct())
                .build();
    }

    @Override
    public List<ProductListResponse> getAllProducts() {
        log.info("[start] ProductApplicationService - getAllProducts");
        List<Product> products = productRepository.getAllProducts();
        log.info("[finish] ProductApplicationService - getAllProducts");
        return ProductListResponse.converte(products);
    }

    @Override
    public ProductResponse getById(Long id) {
        log.info("[start] ProductApplicationService - getById");
        Product product = productRepository.findById(id);
        log.info("[finish] ProductApplicationService - getById");
        return new ProductResponse(product);
    }

    @Override
    public void updateProduct(Long id, ProductAlteracaoRequest productAlteracaoRequest) {
        log.info("[start] ProductApplicationService - updateProduct");
        Product product = productRepository.findById(id);
        product.update(productAlteracaoRequest);
        productRepository.saveProduct(product);
        log.info("[finish] ProductApplicationService - updateProduct");
    }
}