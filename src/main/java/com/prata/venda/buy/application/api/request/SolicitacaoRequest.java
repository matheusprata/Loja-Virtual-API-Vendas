package com.prata.venda.buy.application.api.request;

import com.prata.venda.buy.annotation.TypePayConstraint;
import com.prata.venda.buy.annotation.ValidSolicitacaoRequest;
import com.prata.venda.pay.domain.TypePay;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
@ValidSolicitacaoRequest
public class SolicitacaoRequest {
    @NotNull(message = "Necessario o id do product")
    Long idProduct;
    @NotNull(message = "O tipo de buy não pode ser nulo")
    TypePay typePay;
    @DecimalMin(message = "O valor de entrada não pode ser negativo", value = "0.0")
    BigDecimal valorEntrada;
    int desconto;
    @NotNull(message = "Campo Obrigatório!")
    @Min(value = 1, message = "O valor mínimo é 1")
    @Max(value = 12, message = "O valor máximo é 12")
    int quantidadeParcelas;
    @TypePayConstraint(message = "O tipo de buy de entrada deve ser DINHEIRO, CARTAO_DEBITO ou PIX")
    String typePayEntrada;
    String observacao;
}