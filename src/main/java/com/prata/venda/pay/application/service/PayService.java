package com.prata.venda.pay.application.service;

import com.prata.venda.buy.domain.Buy;
import com.prata.venda.pay.application.api.PayRequest;
import com.prata.venda.pay.application.api.PayResponse;
import com.prata.venda.pay.domain.Pay;
import com.prata.venda.pay.domain.TypePay;

import java.util.List;

public interface PayService {
    PayResponse savePay(Long idBuy, PayRequest payRequest);
    List<PayResponse> getAllPayByBuy(Long idBuy);
    PayResponse getOnePay(Long idPay);
    Pay savePayByEntrada(Buy buy, TypePay typePayEntrada);
    void deletePay(Long idPay);
}