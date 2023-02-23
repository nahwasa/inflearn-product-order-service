package com.nahwasa.study.inflearnproductorderservice.product.adapter;

import com.nahwasa.study.inflearnproductorderservice.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
