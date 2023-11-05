package com.prata.venda.pay.infra;

import com.prata.venda.buy.domain.Buy;
import com.prata.venda.handler.APIException;
import com.prata.venda.pay.application.repository.PayRepository;
import com.prata.venda.pay.domain.Pay;
import com.prata.venda.pay.domain.TypePay;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PayInfraRepository implements PayRepository {
    private final PaySpringDataJPARepository paySpringDataJPARepository;

    @Override
    public Pay salvaPay(Pay pay) {
        log.info("[inicia] PayInfraRepository - salva");
        Pay pago = paySpringDataJPARepository.save(pay);
        log.info("[inicia] PayInfraRepository - salva");
        return pago;
    }

    @Override
    public List<Pay> getAllPayByBuy(Buy buy) {
        log.info("[inicia] PayInfraRepository - getPay");
        List<Pay> pays = paySpringDataJPARepository.findByBuy(buy);
        log.info("[finaliza] PayInfraRepository - getPay");
        return pays;
    }

    @Override
    public BigDecimal totalPago(Buy buy) {
        log.info("[inicia] PayInfraRepository - totalPago");
        List<Pay> pays = paySpringDataJPARepository.findByBuy(buy);
        BigDecimal totalPago = pays.stream()
                .map(Pay::getValorPago)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        log.info("[finaliza] PayInfraRepository - totalPago");
        return totalPago;
    }

    @Override
    public Pay getOnePay(Long idPay) {
        log.info("[inicia] PayInfraRepository - getById");
        Optional<Pay> optionalPay = paySpringDataJPARepository.findById(idPay);
        Pay pay = optionalPay
                .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND,"Pay inexistente!"));
        log.info("[finaliza] PayInfraRepository - getById");
        return pay;
    }

    @Override
    public void deletePay(Long idPay) {
        log.info("[inicia] PayInfraRepository - delete");
        paySpringDataJPARepository.deleteById(idPay);
        log.info("[inicia] PayInfraRepository - delete");
    }

    @Override
    public List<Pay> getAllPayByData(LocalDate data) {
        log.info("[inicia] PayInfraRepository - getAllPayByData");
        List<Pay> pays = paySpringDataJPARepository.findByDataPay(data);
        log.info("[finaliza] PayInfraRepository - getAllPayByData");
        return pays;
    }

    @Override
    public List<Pay> getAllPayByTypePay(TypePay typePay, LocalDate data) {
        log.info("[inicia] PayInfraRepository - getAllPayByTypePay");
        List<Pay> pays = paySpringDataJPARepository.findByTypePayAndDataPay(typePay,data);;
        log.info("[finaliza] PayInfraRepository - getAllPayByTypePay");
        return pays;
    }
}