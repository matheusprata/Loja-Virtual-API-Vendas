package com.prata.venda.cart.application.service;

import com.prata.venda.cart.application.api.CartRequest;
import com.prata.venda.cart.application.api.CartResponse;
import com.prata.venda.cart.application.repository.CartRepository;
import com.prata.venda.cart.domain.Cart;
import com.prata.venda.product.application.repository.ProductRepository;
import com.prata.venda.product.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static com.prata.venda.buy.annotation.constraints.Valid.validaSolicitacao;

@Service
@Log4j2
@RequiredArgsConstructor
public class CartApplicationService implements CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Override
    public CartResponse saveCart(CartRequest cartRequest) {
        log.info("[inicia] CartApplicationService - saveCart");
        Product product = productRepository.findById(cartRequest.getIdProduct());
        validaSolicitacao(cartRequest, product);
        Cart cart = cartRepository.saveCart(new Cart(product, cartRequest));
        log.info("[finaliza] CartApplicationService - saveCart");
        return new CartResponse(cart);
    }

    @Override
    public CartResponse getOneCart(Long idCart) {
        log.info("[inicia] CartApplicationService - getOneCart");
        Cart cart = cartRepository.getOneCart(idCart);
        log.info("[finaliza] CartApplicationService - getOneCart");
        return new CartResponse(cart);
    }
}