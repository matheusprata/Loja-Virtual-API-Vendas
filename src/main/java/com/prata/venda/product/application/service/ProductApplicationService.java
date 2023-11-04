package com.prata.venda.product.application.service;

import com.prata.venda.product.application.api.ProductIdResponse;
import com.prata.venda.product.application.api.ProductRequest;
import com.prata.venda.product.application.repository.ProductRepository;
import com.prata.venda.product.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}