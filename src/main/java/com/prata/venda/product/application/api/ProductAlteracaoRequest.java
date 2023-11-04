package com.prata.venda.product.application.api;

import com.prata.venda.product.domain.Promotion;
import lombok.Value;

@Value
public class ProductAlteracaoRequest {
    String name;
    double price;
    Promotion promotion;
}
