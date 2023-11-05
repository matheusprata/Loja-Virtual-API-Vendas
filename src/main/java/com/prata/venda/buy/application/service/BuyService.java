package com.prata.venda.buy.application.service;

import com.prata.venda.buy.application.api.request.BuyAlteracaoRequest;
import com.prata.venda.buy.application.api.request.BuyRequest;
import com.prata.venda.buy.application.api.response.BuyDetalhadoResponse;
import com.prata.venda.buy.application.api.response.BuyIdResponse;
import com.prata.venda.buy.application.api.response.BuyListResponse;
import java.util.List;

public interface BuyService {
    BuyIdResponse saveBuy(BuyRequest buyRequest);
    List<BuyListResponse> getAllBuys();
    BuyDetalhadoResponse getOneBuy(Long idBuy);
    void deleteBuy(Long idBuy);
    void updateBuy(Long idBuy, BuyAlteracaoRequest buyAlteracaoRequest);
    void esgotadoBuy(Long idBuy);
    void disponivelBuy(Long idBuy);
    void aguardandoChegarBuy(Long idBuy);
    BuyIdResponse saveBuyByCart(Long idCart);
}