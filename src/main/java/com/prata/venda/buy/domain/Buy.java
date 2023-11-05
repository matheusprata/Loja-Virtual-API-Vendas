package com.prata.venda.buy.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prata.venda.buy.application.api.request.BuyAlteracaoRequest;
import com.prata.venda.buy.application.api.request.BuyRequest;
import com.prata.venda.cart.domain.Cart;
import com.prata.venda.pay.domain.Pay;
import com.prata.venda.pay.domain.TypePay;
import com.prata.venda.product.domain.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static com.prata.venda.buy.annotation.constraints.Valid.calcularValorFinal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "TB_BUY")
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBuy;

    @ManyToOne
    @JsonIgnore
    private Product product;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buy")
    @JsonIgnore
    private List<Pay> payments;

    @Enumerated(EnumType.STRING)
    private TypePay typePay;
    private BigDecimal valorEntrada;
    private int desconto;
    @Min(value = 1, message = "O valor mínimo é 1")
    @Max(value = 12, message = "O valor máximo é 12")
    private int quantidadeParcelas;
    private BigDecimal valorFinal;
    private LocalDate dataBuy = LocalDate.now();
    private String observacao;
    @Enumerated(EnumType.STRING)
    private Status status = Status.DISPONIVEL;

    public Buy(Product product, BuyRequest buyRequest) {
        this.product = product;
        this.typePay = buyRequest.getTypePay();
        this.valorEntrada = buyRequest.getValorEntrada();
        this.desconto = buyRequest.getDesconto();
        this.quantidadeParcelas = buyRequest.getQuantidadeParcelas();
        this.observacao = buyRequest.getObservacao().toUpperCase();
        this.valorFinal = calcularValorFinal(buyRequest.getDesconto(), product.getPrice());
    }

    public Buy(Cart cart) {
        this.product = cart.getProduct();
        this.typePay = cart.getTypePay();
        this.valorEntrada = cart.getValorEntrada();
        this.desconto = cart.getDesconto();
        this.quantidadeParcelas = cart.getQuantidadeParcelas();
        this.observacao = cart.getObservacao().toUpperCase();
        this.valorFinal = cart.getValorFinal();
    }

    public void altera(BuyAlteracaoRequest buyAlteracaoRequest) {
        this.typePay = buyAlteracaoRequest.getTypePay();
        this.valorEntrada = buyAlteracaoRequest.getValorEntrada();
        this.desconto = buyAlteracaoRequest.getDesconto();
        this.quantidadeParcelas = buyAlteracaoRequest.getQuantidadeParcelas();
        this.observacao = buyAlteracaoRequest.getObservacao().toUpperCase();
    }

    public void esgotadoBuy() {this.status = Status.ESGOTADO; }

    public void disponivelBuy() { this.status = Status.DISPONIVEL; }

    public void aguardandoChegarBuy() { this.status = Status.AGUARDANDO_CHEGAR; }
}