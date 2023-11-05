package com.prata.venda.cart.application.api;

import com.prata.venda.cart.domain.Cart;
import com.prata.venda.pay.domain.TypePay;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CartResponse {
    Long idCart;
    TypePay typePay;
    LocalDate dataCart;
    BigDecimal valorEntrada;
    int desconto;
    int quantidadeParcelas;
    String observacao;
    LocalDate validade;
    BigDecimal valorFinal;

    public CartResponse(Cart cart) {
        this.idCart = cart.getIdCart();
        this.typePay = cart.getTypePay();
        this.dataCart = cart.getDataCart();
        this.valorEntrada = cart.getValorEntrada();
        this.desconto = cart.getDesconto();
        this.quantidadeParcelas = cart.getQuantidadeParcelas();
        this.observacao = cart.getObservacao();
        this.validade = cart.getValidade();
        this.valorFinal = cart.getValorFinal();
    }
}