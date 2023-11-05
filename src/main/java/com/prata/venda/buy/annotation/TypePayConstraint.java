package com.prata.venda.buy.annotation;

import com.prata.venda.buy.annotation.constraints.TypePayEntradaValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TypePayEntradaValidator.class)
public @interface TypePayConstraint {
    String message() default "O tipo de buy de entrada deve ser DINHEIRO, CARTAO_DEBITO ou PIX";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
