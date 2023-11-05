package com.prata.venda.buy.application.api;

import com.prata.venda.buy.application.api.request.BuyAlteracaoRequest;
import com.prata.venda.buy.application.api.request.BuyRequest;
import com.prata.venda.buy.application.api.response.BuyDetalhadoResponse;
import com.prata.venda.buy.application.api.response.BuyIdResponse;
import com.prata.venda.buy.application.api.response.BuyListResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Buy", description = "Buy APIs")
@RequestMapping("/v1/buy")
public interface BuyAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    BuyIdResponse saveBuy(@Valid @RequestBody BuyRequest buyRequest);

    @PostMapping(value = "/cart")
    @ResponseStatus(code = HttpStatus.CREATED)
    BuyIdResponse saveBuyByCart(@RequestParam Long idCart);

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    List<BuyListResponse> getAllBuys();

    @GetMapping(value = "/{idBuy}")
    @ResponseStatus(code = HttpStatus.OK)
    BuyDetalhadoResponse getOneBuy(@PathVariable Long idBuy);

    @DeleteMapping(value = "/{idBuy}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteBuy(@PathVariable Long idBuy);

    @PatchMapping(value = "/{idBuy}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateBuy(@PathVariable Long idBuy,
                         @Valid @RequestBody BuyAlteracaoRequest buyAlteracaoRequest);

    @PatchMapping("/finaliza-buy/{idBuy}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void finalizaBuy(@PathVariable Long idBuy);

    @PatchMapping("/ativa-buy/{idBuy}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void ativaBuy(@PathVariable Long idBuy);

    @PatchMapping("/cancela-buy/{idBuy}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void cancelaBuy(@PathVariable Long idBuy);
}