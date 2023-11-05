package com.prata.venda.pay.application.repository;

import com.prata.venda.buy.domain.Buy;
import com.prata.venda.pay.domain.Pay;
import com.prata.venda.pay.domain.TypePay;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface PayRepository {
    List<Pay> getAllPayByBuy(Buy buy);
    BigDecimal totalPago(Buy buy);
    Pay salvaPay(Pay pay);
    Pay getOnePay(Long idPay);
    void deletePay(Long idPay);
    List<Pay> getAllPayByData(LocalDate data);
    List<Pay> getAllPayByTypePay(TypePay typePay, LocalDate data);
}