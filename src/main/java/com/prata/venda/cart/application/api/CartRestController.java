package com.prata.venda.cart.application.api;

import com.prata.venda.cart.application.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class CartRestController implements CartAPI {
    private final CartService cartService;

    @Override
    public CartResponse saveCart(CartRequest cartRequest) {
        log.info("[inicia] CartRestController - saveCart");
        CartResponse cartCriado = cartService.saveCart(cartRequest);
        log.info("[finaliza] CartRestController - saveCart");
        return cartCriado;
    }
    @Override
    public CartResponse getOneCart(Long idCart) {
        log.info("[inicia] CartRestController - getOneCart");
        CartResponse cartResponse = cartService.getOneCart(idCart);
        log.info("[finaliza] CartRestController - getOneCart");
        return cartResponse;
    }
}