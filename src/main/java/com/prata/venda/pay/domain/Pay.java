package com.prata.venda.pay.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prata.venda.buy.domain.Buy;
import com.prata.venda.pay.application.api.PayRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "TB_PAY")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPay;
    private LocalDate dataPay = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private TypePay typePay;
    private BigDecimal valorPago;

    @ManyToOne
    @JoinColumn(name = "buy_id")
    @JsonIgnore
    private Buy buy;

    public Pay(PayRequest payRequest, Buy buy) {
        this.typePay = payRequest.getTypePay();
        this.valorPago = payRequest.getValorPago();
        this.buy = buy;
    }
    public Pay(Buy buy, TypePay typePayEntrada) {
        this.typePay = typePayEntrada;
        this.valorPago = buy.getValorEntrada();
        this.buy = buy;
    }
}