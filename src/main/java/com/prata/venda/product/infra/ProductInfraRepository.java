package com.prata.venda.product.infra;

import com.prata.venda.handler.APIException;
import com.prata.venda.product.application.repository.ProductRepository;
import com.prata.venda.product.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ProductInfraRepository implements ProductRepository {
    private final ProductSpringDataJPARepository productSpringDataJPARepository;

    @Override
    public Product saveProduct(Product product) {
        log.info("[start] ProductInfraRepository - saveProduct");
        try {
            productSpringDataJPARepository.save(product);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Produto já cadastrado", e);
        }
        log.info("[finish] ProductInfraRepository - saveProdutc");
        return product;
    }
}