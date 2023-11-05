package com.prata.venda.buy.infra;

import com.prata.venda.buy.domain.Buy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuySpringDataJPARepository extends JpaRepository<Buy, Long> {
}