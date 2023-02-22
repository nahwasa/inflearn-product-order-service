package com.nahwasa.study.inflearnproductorderservice.product;

import org.assertj.core.api.Assertions;
import org.hibernate.query.sqm.tree.domain.AbstractSqmJoin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    /**
     * 도메인 로직은 반드시 테스트 해야 함.
     */
    @Test
    void update() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
        
        product.update("상품 수정", 2000, DiscountPolicy.NONE);

        Assertions.assertThat(product.getName()).isEqualTo("상품 수정");
        Assertions.assertThat(product.getPrice()).isEqualTo(2000);
    }
}