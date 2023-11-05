package com.prata.venda.buy.annotation.constraints;

import com.prata.venda.buy.annotation.ValidSolicitacaoRequest;
import com.prata.venda.buy.application.api.request.SolicitacaoRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;
import java.util.Objects;

public class SolicitacaoRequestValidator implements ConstraintValidator<ValidSolicitacaoRequest, SolicitacaoRequest> {

    @Override
    public boolean isValid(SolicitacaoRequest request, ConstraintValidatorContext context) {
        BigDecimal valorEntrada = request.getValorEntrada();
        String typePayEntrada = request.getTypePayEntrada();

        if ((valorEntrada.compareTo(BigDecimal.ZERO) > 0 && typePayEntrada.isEmpty()) ||
        valorEntrada.compareTo(BigDecimal.ZERO) == 0 && !Objects.equals(typePayEntrada, "")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("O tipo de buy de entrada deve ser " +
                            "informado quando o valor de entrada é maior do que zero")
                    .addPropertyNode("typePayEntrada")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
