package com.prata.venda.buy.annotation.constraints;

import com.prata.venda.buy.application.api.request.BuyAlteracaoRequest;
import com.prata.venda.buy.application.api.request.SolicitacaoRequest;
import com.prata.venda.buy.domain.Buy;
import com.prata.venda.handler.APIException;
import com.prata.venda.pay.domain.TypePay;
import com.prata.venda.product.domain.Product;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Valid {
    public static void validaSolicitacao(SolicitacaoRequest request, Product product) {
        validarTypePayETotalParcelas(request.getTypePay(), request.getQuantidadeParcelas());
        validaEntrada(request.getValorEntrada(), product.getPrice(), request.getDesconto());
    }

    public static void validaAlteracaoBuy(Buy buy, BuyAlteracaoRequest request) {
        validarTypePayETotalParcelas(request.getTypePay(), request.getQuantidadeParcelas());
        validaEntrada(request.getValorEntrada(), buy.getProduct().getPrice(), request.getDesconto());
    }

    public static void validarTypePayETotalParcelas(TypePay typePay, int quantidadeParcelas) {
        if (typePay == TypePay.DINHEIRO || typePay == TypePay.CARTAO_DEBITO ||
                typePay == TypePay.PIX || typePay == TypePay.BOLETO) {
            if (quantidadeParcelas != 1) {
                throw APIException
                        .build(HttpStatus.BAD_REQUEST,"Quantidade de parcelas inválida para o tipo de buy escolhido.");
            }
        } else if (typePay == TypePay.CARTAO_CREDITO) {
            if (quantidadeParcelas < 1) {
                throw APIException
                        .build(HttpStatus.BAD_REQUEST,"Quantidade de parcelas inválida para o tipo de buy escolhido.");
            }
        }
    }

    public  static void validaEntrada(BigDecimal valorEntrada, BigDecimal price, int desconto){
        BigDecimal valorFinal = calcularValorFinal(desconto, price);
        if(valorEntrada.compareTo(price) > 0){
            throw APIException
                    .build(HttpStatus.BAD_REQUEST,"Valor entrada R$: "+valorEntrada + " maior que o valor contratado, " +
                            "Valor Serviço R$: " + price + " - desconto de " + desconto+"% igual a R$: " + valorFinal);
        }
    }

    public static BigDecimal calcularValorFinal(int desconto, BigDecimal valorProduct) {
        final int DESCONTO_MAXIMO = 100;
        final int DESCONTO_MINIMO = 0;

        if (desconto < DESCONTO_MINIMO || desconto > DESCONTO_MAXIMO) {
            throw APIException.build(HttpStatus.BAD_REQUEST,"O desconto deve ser um valor entre 0 e 100");
        }
        if (valorProduct.compareTo(BigDecimal.ZERO) <= 0) {
            throw APIException.build(HttpStatus.BAD_REQUEST,"O valor do serviço deve ser maior que zero");
        }
        BigDecimal valorDescontado = valorProduct.multiply(new BigDecimal(desconto)).divide(BigDecimal.valueOf(100),
                2, RoundingMode.HALF_UP);
        return valorProduct.subtract(valorDescontado);
    }
}