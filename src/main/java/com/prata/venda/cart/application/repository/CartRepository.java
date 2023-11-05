package com.prata.venda.cart.application.repository;

import com.prata.venda.cart.domain.Cart;

public interface CartRepository {
    Cart saveCart(Cart cart);
    Cart getOneCart(Long idCart);
    void deleteCartExpirado();
    void deleteCart(Long idCart);
}
