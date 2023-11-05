package com.prata.venda.buy.annotation.constraints;

import com.prata.venda.buy.annotation.TypePayConstraint;
import com.prata.venda.pay.domain.TypePay;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class TypePayEntradaValidator implements ConstraintValidator<TypePayConstraint, String> {
    @Override
    public boolean isValid(String typePayEntrada, ConstraintValidatorContext context) {
        if (Objects.equals(typePayEntrada, "")) {
            return true;
        }
        return typePayEntrada.equals(TypePay.DINHEIRO.toString()) ||
                typePayEntrada.equals(TypePay.CARTAO_DEBITO.toString()) ||
                typePayEntrada.equals(TypePay.PIX.toString());
    }
}
