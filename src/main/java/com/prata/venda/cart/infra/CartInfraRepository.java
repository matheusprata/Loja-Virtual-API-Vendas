package com.prata.venda.cart.infra;

import com.prata.venda.cart.application.repository.CartRepository;
import com.prata.venda.cart.domain.Cart;
import com.prata.venda.handler.APIException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Log4j2
public class CartInfraRepository implements CartRepository {
    private final CartSpringDataJPARepository cartSpringDataJPARepository;

    @Override
    public Cart saveCart(Cart cart) {
        log.info("[inicia] CartInfraRepository - saveCart");
        Cart cartCriado = cartSpringDataJPARepository.save(cart);
        log.info("[finaliza] CartInfraRepository - saveCart");
        return cartCriado;
    }
    @Override
    public Cart getOneCart(Long idCart) {
        log.info("[inicia] CartInfraRepository - getOneCart");
        Optional<Cart> optionalCart = cartSpringDataJPARepository.findById(idCart);
        Cart cart = optionalCart
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,
                                "Cart Not Found!"));
        log.info("[finaliza] CartInfraRepository - getOneCart");
        return (cart);
    }

    @Scheduled(fixedRate = 86400000) // Executa a cada 24 horas)
    @Override
    @Transactional
    public void deleteCartExpirado() {
        log.info("[inicia] CartInfraRepository - deleteCartExpirado");
        cartSpringDataJPARepository.deleteCartExpirado(LocalDate.now());
        log.info("[finaliza] CartInfraRepository - deleteCartExpirado");
    }

    @Override
    public void deleteCart(Long idCart) {
        log.info("[inicia] CartInfraRepository - deleteCart");
        cartSpringDataJPARepository.deleteById(idCart);
        log.info("[finaliza] CartInfraRepository - deleteCart");
    }
}