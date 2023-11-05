package com.prata.venda.product.domain;

import com.prata.venda.cart.domain.Cart;
import com.prata.venda.product.application.api.ProductAlteracaoRequest;
import com.prata.venda.product.application.api.ProductRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduct;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<Cart> carts;

    @NotBlank
    private String name;
    @NotNull
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Promotion promotion;

    public Product(ProductRequest productRequest) {
        this.name = productRequest.getName();
        this.price = productRequest.getPrice();
        this.promotion = productRequest.getPromotion();
    }

    public void update(ProductAlteracaoRequest productAlteracaoRequest) {
        this.name = productAlteracaoRequest.getName();
        this.price = productAlteracaoRequest.getPrice();
        this.promotion = productAlteracaoRequest.getPromotion();
    }
}