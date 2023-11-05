package com.prata.venda.buy.application.api;

import com.prata.venda.buy.application.api.request.BuyAlteracaoRequest;
import com.prata.venda.buy.application.api.request.BuyRequest;
import com.prata.venda.buy.application.api.response.BuyDetalhadoResponse;
import com.prata.venda.buy.application.api.response.BuyIdResponse;
import com.prata.venda.buy.application.api.response.BuyListResponse;
import com.prata.venda.buy.application.service.BuyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class BuyRestController implements BuyAPI {
    private final BuyService buyService;

    @Override
    public BuyIdResponse saveBuy(BuyRequest buyRequest) {
        log.info("[inicia] BuyRestController - saveBuy");
        BuyIdResponse buyCriado = buyService.saveBuy(buyRequest);
        log.info("[finaliza] BuyRestController - saveBuy");
        return buyCriado;
    }

    @Override
    public BuyIdResponse saveBuyByCart(Long idCart) {
        log.info("[inicia] BuyRestController -saveBuyByCart");
        BuyIdResponse buyCriado = buyService.saveBuyByCart(idCart);
        log.info("[finaliza] BuyRestController - saveBuyByCart");
        return buyCriado;
    }

    @Override
    public List<BuyListResponse> getAllBuys() {
        log.info("[inicia] BuyRestController - getAllBuys");
        List<BuyListResponse> buys = buyService.getAllBuys();
        log.info("[finaliza] BuyRestController - getAllBuys");
        return buys;
    }

    @Override
    public BuyDetalhadoResponse getOneBuy(Long idBuy) {
        log.info("[inicia] BuyRestController - getOneBuy");
        log.info("idBuy {}", idBuy);
        BuyDetalhadoResponse buyDetalhadoResponse = buyService.getOneBuy(idBuy);
        log.info("[finaliza] BuyRestController - getOneBuy");
        return buyDetalhadoResponse;
    }

    @Override
    public void deleteBuy(Long idBuy) {
        log.info("[inicia] BuyRestController - deleteBuy");
        buyService.deleteBuy(idBuy);
        log.info("[finaliza] BuyRestController - deleteBuy");
    }

    @Override
    public void updateBuy(Long idBuy, BuyAlteracaoRequest buyAlteracaoRequest) {
        log.info("[inicia] BuyRestController - updateBuy");
        buyService.updateBuy(idBuy, buyAlteracaoRequest);
        log.info("[finaliza] BuyRestController - updateBuy");
    }

    @Override
    public void finalizaBuy(Long idBuy) {
        log.info("[inicia] BuyRestController - finalizaBuy");
        buyService.esgotadoBuy(idBuy);
        log.info("[finaliza] BuyRestController - finalizaBuy");
    }

    @Override
    public void ativaBuy(Long idBuy) {
        log.info("[inicia] BuyRestController - ativaBuy");
        buyService.disponivelBuy(idBuy);
        log.info("[finaliza] BuyRestController - ativaBuy");
    }

    @Override
    public void cancelaBuy(Long idBuy) {
        log.info("[inicia] BuyRestController - cancelaBuy");
        buyService.aguardandoChegarBuy(idBuy);
        log.info("[finaliza] BuyRestController - cancelaBuy");
    }
}