package com.prata.venda.product.application.api;

import com.prata.venda.product.domain.Promotion;
import lombok.Value;
import java.math.BigDecimal;

@Value
public class ProductAlteracaoRequest {
    String name;
    BigDecimal price;
    Promotion promotion;
}