package com.prata.venda.product.application.api;

import com.prata.venda.product.domain.Product;
import com.prata.venda.product.domain.Promotion;
import lombok.Value;

@Value
public class ProductResponse {
    Long idProduct;
    String name;
    double price;
    Promotion promotion;

    public ProductResponse(Product product){
        this.idProduct = product.getIdProduct();
        this.name = product.getName();
        this.price = product.getPrice();
        this.promotion = product.getPromotion();
    }
}
