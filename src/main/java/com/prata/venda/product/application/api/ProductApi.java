package com.prata.venda.product.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Product", description = "Product APIs")
@RequestMapping("/v1/product")
public interface ProductApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ProductIdResponse newProduct(@Valid @RequestBody ProductRequest productRequest);

    @GetMapping(value = "/all")
    @ResponseStatus(code = HttpStatus.OK)
    List<ProductListResponse> getAllProduct();

    @GetMapping(value = "/id")
    @ResponseStatus(code = HttpStatus.OK)
    ProductResponse getById(@RequestParam Long id);

    @PatchMapping(value = "/id")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateProduct(@RequestParam Long id,
                     @Valid @RequestBody ProductAlteracaoRequest productAlteracaoRequest);
}