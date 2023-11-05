package com.prata.venda.pay.application.api;

import com.prata.venda.pay.domain.TypePay;
import lombok.Value;
import java.math.BigDecimal;

@Value
public class PayRequest {
    TypePay typePay;
    BigDecimal valorPago;
}