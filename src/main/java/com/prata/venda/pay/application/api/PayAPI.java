package com.prata.venda.pay.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Pay", description = "Pay APIs")
@RequestMapping("/v1/pay")
public interface PayAPI {

    @PostMapping("/{idBuy}")
    @ResponseStatus(code = HttpStatus.CREATED)
    PayResponse savePay(@PathVariable Long idBuy, @Valid @RequestBody PayRequest payRequest);

    @GetMapping(value = "/buy/{idBuy}")
    @ResponseStatus(code = HttpStatus.OK)
    List<PayResponse> getAllPayByBuy(@PathVariable Long idBuy);

    @GetMapping("/{idPay}")
    @ResponseStatus(code = HttpStatus.OK)
    PayResponse getOnePay(@PathVariable Long idPay);

    @DeleteMapping("/{idPay}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletePay(@PathVariable Long idPay);
}