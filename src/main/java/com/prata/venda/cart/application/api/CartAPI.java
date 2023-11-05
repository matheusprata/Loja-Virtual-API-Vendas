package com.prata.venda.cart.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Cart", description = "Cart APIs")
@RequestMapping("/v1/cart")
public interface CartAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CartResponse saveCart(@Valid @RequestBody CartRequest cartRequest);

    @GetMapping(value = "/{idCart}")
    @ResponseStatus(code = HttpStatus.OK)
    CartResponse getOneCart(@PathVariable Long idCart);
}