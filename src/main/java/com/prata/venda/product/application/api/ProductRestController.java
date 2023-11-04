package com.prata.venda.product.application.api;

import com.prata.venda.product.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ProductRestController implements ProductApi{
    private final ProductService productService;

    @Override
    public ProductIdResponse newProduct(ProductRequest productRequest) {
        log.info("[start] ProductRestController - newProduct");
        ProductIdResponse idResponse = productService.saveProdutc(productRequest);
        log.info("[finish] ProductRestController - newProduct");
        return idResponse;
    }

    @Override
    public List<ProductListResponse> getAllProduct() {
        log.info("[start] ProductRestController - ProductListResponse");
        List<ProductListResponse> products = productService.getAllProducts();
        log.info("[finish] ProductRestController - ProductListResponse");
        return products;
    }

    @Override
    public ProductResponse getById(Long id) {
        log.info("[start] ProductRestController - getById");
        ProductResponse getId = productService.getById(id);
        log.info("[finish] ProductRestController - getById");
        return getId;
    }

    @Override
    public void updateProduct(Long id, ProductAlteracaoRequest productAlteracaoRequest) {
        log.info("[start] ProductRestController - updateProduct");
        productService.updateProduct(id, productAlteracaoRequest);
        log.info("[finish] ProductRestController - updateProduct");
    }
}