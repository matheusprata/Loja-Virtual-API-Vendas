package com.prata.venda.buy.application.api.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BuyRequest extends SolicitacaoRequest{
    Long idCliente;
}