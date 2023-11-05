package com.prata.venda.cart.infra;

import com.prata.venda.cart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.Optional;

public interface CartSpringDataJPARepository extends JpaRepository<Cart, Long> {
    @Modifying
    @Query("DELETE FROM Cart o WHERE o.validade = :now")
    void deleteCartExpirado(LocalDate now);
    Optional<Cart> findById(Long id);
}