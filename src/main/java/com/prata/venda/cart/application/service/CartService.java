package com.prata.venda.cart.application.service;

import com.prata.venda.cart.application.api.CartRequest;
import com.prata.venda.cart.application.api.CartResponse;

public interface CartService {
    CartResponse saveCart(CartRequest cartRequest);
    CartResponse getOneCart(Long idCart);
}