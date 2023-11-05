package com.prata.venda.pay.application.api;

import com.prata.venda.pay.application.service.PayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PayRestController implements PayAPI {
    private final PayService payService;

    @Override
    public PayResponse savePay(Long idBuy, PayRequest payRequest) {
        log.info("[inicia] PayRestController - savePay");
        PayResponse payResponse = payService.savePay(idBuy, payRequest);
        log.info("[finaliza] PayRestController - savePay");
        return payResponse;
    }
    @Override
    public List<PayResponse> getAllPayByBuy(Long idBuy) {
        log.info("[inicia] PayRestController - getAllPayByBuy");
        List<PayResponse>  getPay = payService.getAllPayByBuy(idBuy);
        log.info("[finaliza] PayRestController - getAllPayByBuy");
        return getPay;
    }
    @Override
    public PayResponse getOnePay(Long idPay) {
        log.info("[inicia] PayRestController - getOnePay");
        PayResponse payResponse = payService.getOnePay(idPay);
        log.info("[finaliza] PayRestController - getOnePay");
        return payResponse;
    }
    @Override
    public void deletePay(Long idPay) {
        log.info("[inicia] PayRestController - deletePay");
        payService.deletePay(idPay);
        log.info("[finaliza] PayRestController - deletePay");
    }
}