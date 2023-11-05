package com.prata.venda.product.application.api;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ProductIdResponse {
    Long idProduct;
}
