package com.prata.venda.buy.application.service;

import com.prata.venda.buy.application.api.request.BuyAlteracaoRequest;
import com.prata.venda.buy.application.api.request.BuyRequest;
import com.prata.venda.buy.application.api.response.BuyDetalhadoResponse;
import com.prata.venda.buy.application.api.response.BuyIdResponse;
import com.prata.venda.buy.application.api.response.BuyListResponse;
import com.prata.venda.buy.application.repository.BuyRepository;
import com.prata.venda.buy.domain.Buy;
import com.prata.venda.cart.application.repository.CartRepository;
import com.prata.venda.cart.domain.Cart;
import com.prata.venda.pay.application.service.PayService;
import com.prata.venda.pay.domain.Pay;
import com.prata.venda.pay.domain.TypePay;
import com.prata.venda.product.application.repository.ProductRepository;
import com.prata.venda.product.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

import static com.prata.venda.buy.annotation.constraints.Valid.validaAlteracaoBuy;
import static com.prata.venda.buy.annotation.constraints.Valid.validaSolicitacao;

@Service
@Log4j2
@RequiredArgsConstructor
public class BuyApplicationService implements BuyService {
    private final BuyRepository buyRepository;
    private final ProductRepository productRepository;
    private final PayService payService;
    private final CartRepository cartRepository;

    @Override
    public BuyIdResponse saveBuy(BuyRequest buyRequest) {
        log.info("[inicia] BuyApplicationService - saveBuy");
        Product product = productRepository.findById(buyRequest.getIdProduct());
        validaSolicitacao(buyRequest, product);
        Buy buy = buyRepository.saveBuy(new Buy(product, buyRequest));
        if (buyRequest.getValorEntrada().compareTo(BigDecimal.ZERO)>0){
            Pay pay = payService.savePayByEntrada(buy, TypePay.valueOf(buyRequest.getTypePayEntrada()));
        }
        log.info("[finaliza] BuyApplicationService - saveBuy");
        return BuyIdResponse.builder().idBuy(buy.getIdBuy()).build();
    }

    @Override
    public BuyIdResponse saveBuyByCart(Long idCart) {
        log.info("[inicia] BuyApplicationService - saveBuyByCart");
        Cart cart = cartRepository.getOneCart(idCart);
        Buy buy = buyRepository.saveBuy(new Buy(cart));
        cartRepository.deleteCart(cart.getIdCart());
        log.info("[finaliza] BuyApplicationService - saveBuyByCart");
        return BuyIdResponse.builder().idBuy(buy.getIdBuy()).build();
    }

    @Override
    public List<BuyListResponse> getAllBuys() {
        log.info("[inicia] BuyApplicationService - getAllBuys");
        List<Buy> buys = buyRepository.getAllBuys();
        log.info("[finaliza] BuyApplicationService - getAllBuys");
        return BuyListResponse.converte(buys);
    }

    @Override
    public BuyDetalhadoResponse getOneBuy(Long idBuy) {
        log.info("[inicia] BuyApplicationService - getOneBuy");
        Buy buy = buyRepository.getOneBuy(idBuy);
        log.info("[finaliza] BuyApplicationService - getOneBuy");
        return new BuyDetalhadoResponse(buy);
    }

    @Override
    public void deleteBuy(Long idBuy) {
        log.info("[inicia] BuyApplicationService - deleteBuy");
        Buy buy = buyRepository.getOneBuy(idBuy);
        buyRepository.deleteBuy(buy);
        log.info("[finaliza] BuyApplicationService - deleteBuy");
    }

    @Override
    public void updateBuy(Long idBuy, BuyAlteracaoRequest request) {
        log.info("[inicia] BuyApplicationService - updateBuy");
        Buy buy = buyRepository.getOneBuy(idBuy);
        validaAlteracaoBuy(buy, request);
        buy.altera(request);
        buyRepository.saveBuy(buy);
        log.info("[finaliza] BuyApplicationService - updateBuy");
    }

    @Override
    public void esgotadoBuy(Long idBuy) {
        log.info("[inicia] BuyApplicationService - finalizaBuy");
        Buy buy = buyRepository.getOneBuy(idBuy);
        buy.esgotadoBuy();
        buyRepository.saveBuy(buy);
        log.info("[finaliza] BuyApplicationService - finalizaBuy");
    }

    @Override
    public void disponivelBuy(Long idBuy) {
        log.info("[inicia] BuyApplicationService - ativaBuy");
        Buy buy = buyRepository.getOneBuy(idBuy);
        buy.disponivelBuy();
        buyRepository.saveBuy(buy);
        log.info("[finaliza] BuyApplicationService - ativaBuy");
    }

    @Override
    public void aguardandoChegarBuy(Long idBuy) {
        log.info("[inicia] BuyApplicationService - cancelaBuy");
        Buy buy = buyRepository.getOneBuy(idBuy);
        buy.aguardandoChegarBuy();
        buyRepository.saveBuy(buy);
        log.info("[finaliza] BuyApplicationService - cancelaBuy");
    }
}