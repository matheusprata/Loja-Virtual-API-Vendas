package com.prata.venda.product.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

//Tag(name = "Product", description = "Product APIs")
@RequestMapping("/v1/product")
public interface ProductApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProductIdResponse newProduct(@Valid @RequestBody ProductRequest productRequest);
}
