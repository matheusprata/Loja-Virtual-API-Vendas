package com.prata.venda.buy.infra;

import com.prata.venda.buy.application.repository.BuyRepository;
import com.prata.venda.buy.domain.Buy;
import com.prata.venda.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Log4j2
@RequiredArgsConstructor
public class BuyInfraRepository implements BuyRepository {
    private final BuySpringDataJPARepository buySpringDataJPARepository;

    @Override
    public Buy saveBuy(Buy buy) {
        log.info("[inicia] BuyInfraRepository - saveBuy");
        buySpringDataJPARepository.save(buy);
        log.info("[finaliza] BuyInfraRepository - saveBuy");
        return buy;
    }

    @Override
    public List<Buy> getAllBuys() {
        log.info("[inicia] BuyInfraRepository - getAllBuys");
        List<Buy> todasBuys = buySpringDataJPARepository.findAll();
        log.info("[finaliza] BuyInfraRepository - getAllBuys");
        return todasBuys;
    }

    @Override
    public Buy getOneBuy(Long idBuy) {
        log.info("[inicia] BuyInfraRepository - getOneBuy");
        Optional<Buy> buyOptional = buySpringDataJPARepository.findById(idBuy);
        Buy buy = buyOptional
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Buy não encontrado!"));
        log.info("[finaliza] BuyInfraRepository - getOneBuy");
        return buy;
    }

    @Override
    public void deleteBuy(Buy buy) {
        log.info("[inicia] BuyInfraRepository - deleteBuy");
        buySpringDataJPARepository.delete(buy);
        log.info("[finaliza] BuyInfraRepository - deleteBuy");
    }
}