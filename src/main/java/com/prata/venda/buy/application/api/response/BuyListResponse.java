package com.prata.venda.buy.application.api.response;

import com.prata.venda.buy.domain.Buy;
import com.prata.venda.pay.domain.TypePay;
import lombok.Value;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class BuyListResponse {
    Long idBuy;
    TypePay typePay;
    BigDecimal valorEntrada;
    int desconto;
    int quantidadeParcelas;
    BigDecimal valorFinal;
    LocalDate dataBuy;
    String observacao;
    String status;

    public static List<BuyListResponse> converte(List<Buy> buys){
        return buys.stream()
                .map(BuyListResponse::new)
                .collect(Collectors.toList());
    }

    public BuyListResponse(Buy buy) {
        this.idBuy = buy.getIdBuy();
        this.typePay = buy.getTypePay();
        this.valorEntrada = buy.getValorEntrada();
        this.desconto = buy.getDesconto();
        this.quantidadeParcelas = buy.getQuantidadeParcelas();
        this.valorFinal = buy.getValorFinal();
        this.dataBuy = buy.getDataBuy();
        this.observacao = buy.getObservacao();
        this.status = buy.getStatus().toString();
    }
}