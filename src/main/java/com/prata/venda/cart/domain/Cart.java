package com.prata.venda.cart.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prata.venda.buy.annotation.constraints.Valid;
import com.prata.venda.cart.application.api.CartRequest;
import com.prata.venda.pay.domain.TypePay;
import com.prata.venda.product.domain.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "TB_CART")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCart;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_id")
    private Product product;

    @Enumerated(EnumType.STRING)
    private TypePay typePay;
    protected LocalDate dataCart = LocalDate.now();
    private BigDecimal valorEntrada;
    private int desconto;
    @Min(value = 1, message = "O valor mínimo é 1")
    @Max(value = 12, message = "O valor máximo é 12")
    private int quantidadeParcelas;
    private String observacao;
    private LocalDate validade = dataCart.plusDays(5);
    private BigDecimal valorFinal;

    public Cart(Product product, CartRequest cartRequest) {
        this.product = product;
        this.typePay = cartRequest.getTypePay();
        this.valorEntrada = cartRequest.getValorEntrada();
        this.desconto = cartRequest.getDesconto();
        this.quantidadeParcelas = cartRequest.getQuantidadeParcelas();
        this.observacao = cartRequest.getObservacao();
        this.valorFinal = Valid.calcularValorFinal(cartRequest.getDesconto(), product.getPrice());
    }
}