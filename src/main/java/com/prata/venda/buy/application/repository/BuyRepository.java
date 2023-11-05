package com.prata.venda.buy.application.repository;

import com.prata.venda.buy.domain.Buy;
import java.util.List;

public interface BuyRepository {
    Buy saveBuy(Buy buy);
    List<Buy> getAllBuys();
    Buy getOneBuy(Long idBuy);
    void deleteBuy(Buy buy);
}
