package com.prata.venda.product.infra;

import com.prata.venda.handler.APIException;
import com.prata.venda.product.application.repository.ProductRepository;
import com.prata.venda.product.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Product> getAllProducts() {
        log.info("[start] ProductInfraRepository - getAllProducts");
        List<Product> products = productSpringDataJPARepository.findAll();
        log.info("[finish] ProductInfraRepository - getAllProducts");
        return products;
    }

    @Override
    public Product findById(Long id) {
        log.info("[start] ProductInfraRepository - getOneProduct");
        Optional<Product> optionalProduct = productSpringDataJPARepository.findById(id);
        Product product = optionalProduct
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,"product not found!"));
        log.info("[finish] ProductInfraRepository - getOneProduct");
        return product;
    }
}