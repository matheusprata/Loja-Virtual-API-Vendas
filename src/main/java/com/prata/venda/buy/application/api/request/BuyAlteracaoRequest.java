package com.prata.venda.buy.application.api.request;

import com.prata.venda.pay.domain.TypePay;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class BuyAlteracaoRequest {
    TypePay typePay;
    BigDecimal valorEntrada;
    int desconto;
    @Min(value = 1, message = "O valor mínimo é 1")
    @Max(value = 12, message = "O valor máximo é 12")
    int quantidadeParcelas;
    String observacao;
}