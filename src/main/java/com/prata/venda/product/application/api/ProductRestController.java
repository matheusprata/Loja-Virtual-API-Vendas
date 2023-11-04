package com.prata.venda.product.application.api;

import com.prata.venda.product.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}
