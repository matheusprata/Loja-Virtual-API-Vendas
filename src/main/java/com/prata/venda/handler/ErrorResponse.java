package com.prata.venda.handler;

import lombok.Value;

@Value
public class ErrorResponse {
    int codigo;
    String mensagem;
}
