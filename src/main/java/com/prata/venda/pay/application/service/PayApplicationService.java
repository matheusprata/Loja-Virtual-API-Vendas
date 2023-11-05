package com.prata.venda.pay.application.service;

import com.prata.venda.buy.application.repository.BuyRepository;
import com.prata.venda.buy.domain.Buy;
import com.prata.venda.handler.APIException;
import com.prata.venda.pay.application.api.PayRequest;
import com.prata.venda.pay.application.api.PayResponse;
import com.prata.venda.pay.application.repository.PayRepository;
import com.prata.venda.pay.domain.Pay;
import com.prata.venda.pay.domain.TypePay;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class PayApplicationService implements PayService {
    private final PayRepository payRepository;
    private final BuyRepository buyRepository;

    @Override
    public PayResponse savePay(Long idBuy, PayRequest payRequest) {
        log.info("[inicia] PayApplicationService - savePay");
        Buy buy = buyRepository.getOneBuy(idBuy);
        BigDecimal totalPago = payRepository.totalPago(buy);
        BigDecimal saldoAPagar = buy.getValorFinal().subtract(totalPago);
        if (payRequest.getValorPago().compareTo(saldoAPagar)<=0){
            Pay pay = payRepository.salvaPay(new Pay(payRequest, buy));
            log.info("[finaliza] PayApplicationService - savePay");
            return new PayResponse(pay);
        } else {
            throw APIException.build(HttpStatus.BAD_REQUEST,
                    "Pay maior que o serviço contratado. Valor a Pagar R$: " + saldoAPagar);
        }
    }
    @Override
    public List<PayResponse> getAllPayByBuy(Long idBuy) {
        log.info("[inicia] PayApplicationService - getAllPayByBuy");
        Buy buy = buyRepository.getOneBuy(idBuy);
        List<Pay> pay = payRepository.getAllPayByBuy(buy);
        log.info("[finaliza] PayApplicationService - getAllPayByBuy");
        return PayResponse.convert(pay);
    }
    @Override
    public PayResponse getOnePay(Long idPay) {
        log.info("[inicia] PayApplicationService - getOnePay");
        Pay pay = payRepository.getOnePay(idPay);
        log.info("[finaliza] PayApplicationService - getOnePay");
        return new PayResponse(pay);
    }
    @Override
    public Pay savePayByEntrada(Buy buy, TypePay typePayEntrada) {
        log.info("[inicia] PayApplicationService - savePayByEntrada");
        Pay pay = payRepository.salvaPay(new Pay(buy, typePayEntrada));
        log.info("[finaliza] PayApplicationService - savePayByEntrada");
        return pay;
    }
    @Override
    public void deletePay(Long idPay) {
        log.info("[inicia] PayApplicationService - deletePay");
        payRepository.deletePay(payRepository.getOnePay(idPay).getIdPay());
        log.info("[finaliza] PayApplicationService - deletePay");
    }
}