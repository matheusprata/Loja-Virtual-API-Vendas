package com.prata.venda.product.infra;

import com.prata.venda.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSpringDataJPARepository extends JpaRepository<Product, Long> {
}
