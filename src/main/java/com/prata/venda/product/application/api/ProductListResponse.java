package com.prata.venda.product.application.api;

import com.prata.venda.product.domain.Product;
import com.prata.venda.product.domain.Promotion;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class ProductListResponse {
    Long idProduct;
    String name;
    double price;
    Promotion promotion;

    public static List<ProductListResponse> converte(List<Product> products){
        return products.stream()
                .map(ProductListResponse::new)
                .collect(Collectors.toList());
    }

    public ProductListResponse(Product product){
        this.idProduct = product.getIdProduct();
        this.name = product.getName();
        this.price = product.getPrice();
        this.promotion = product.getPromotion();
    }
}
