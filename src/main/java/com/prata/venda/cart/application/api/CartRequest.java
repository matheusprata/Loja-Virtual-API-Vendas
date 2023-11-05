package com.prata.venda.cart.application.api;

import com.prata.venda.buy.application.api.request.SolicitacaoRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CartRequest extends SolicitacaoRequest {
}