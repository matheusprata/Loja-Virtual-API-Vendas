package com.prata.venda.product.application.api;

import com.prata.venda.product.domain.Promotion;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import java.math.BigDecimal;

@Value
public class ProductRequest {
    @NotBlank
    String name;
    @NotNull
    @Min(value = 1, message = "The price must be greater than zero")
    BigDecimal price;
    Promotion promotion;
}
