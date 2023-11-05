package com.prata.venda.pay.application.api;

import com.prata.venda.pay.domain.Pay;
import lombok.Value;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class PayResponse {
    Long recibo;
    BigDecimal valorContratado;
    BigDecimal valorPago;

    public PayResponse(Pay pay) {
        this.recibo = pay.getIdPay();
        this.valorContratado = pay.getBuy().getValorFinal();
        this.valorPago = pay.getValorPago();
    }

    public static List<PayResponse> convert(List<Pay> pay) {
        return pay.stream()
                .map(PayResponse::new)
                .collect((Collectors.toList()));
    }

    public static String ocultarDocumento(String documento) {
        return documento.replaceAll("\\d{3}\\.\\d{3}", "xxx.xxx");
    }
}
