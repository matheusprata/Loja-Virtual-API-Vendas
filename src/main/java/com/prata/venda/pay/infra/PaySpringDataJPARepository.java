package com.prata.venda.pay.infra;

import com.prata.venda.buy.domain.Buy;
import com.prata.venda.pay.domain.Pay;
import com.prata.venda.pay.domain.TypePay;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface PaySpringDataJPARepository extends JpaRepository<Pay, Long> {
    List<Pay> findByBuy(Buy buy);
    List<Pay> findByDataPay(LocalDate data);
    List<Pay> findByTypePayAndDataPay(TypePay typePay, LocalDate data);
}