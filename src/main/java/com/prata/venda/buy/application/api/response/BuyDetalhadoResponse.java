package com.prata.venda.buy.application.api.response;

import com.prata.venda.buy.domain.Buy;
import com.prata.venda.pay.domain.TypePay;
import lombok.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Value
public class BuyDetalhadoResponse {
    Long idBuy;
    TypePay typePay;
    BigDecimal valorEntrada;
    int quantidadeParcelas;
    BigDecimal price;
    BigDecimal desconto;
    BigDecimal valorFinal;
    LocalDate dataBuy;
    String observacao;
    String status;

    public BuyDetalhadoResponse(Buy buy) {
        this.idBuy = buy.getIdBuy();
        this.dataBuy = buy.getDataBuy();
        this.price = buy.getProduct().getPrice();
        this.valorEntrada = buy.getValorEntrada();
        this.typePay = buy.getTypePay();
        this.quantidadeParcelas = buy.getQuantidadeParcelas();
        this.desconto =  calculaDesconto(buy.getDesconto(), buy.getProduct().getPrice()) ;
        this.valorFinal = buy.getValorFinal();
        this.observacao = buy.getObservacao();
        this.status = buy.getStatus().toString();
    }

    private BigDecimal calculaDesconto(int desconto, BigDecimal valorProduct) {
        return valorProduct.multiply(new BigDecimal(desconto)).divide(BigDecimal.valueOf(100),
                2, RoundingMode.HALF_UP);
    }
}
