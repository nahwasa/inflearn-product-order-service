package com.nahwasa.study.inflearnproductorderservice.product;

import com.nahwasa.study.inflearnproductorderservice.product.domain.DiscountPolicy;
import com.nahwasa.study.inflearnproductorderservice.product.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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

    @Test
    void none_discounted_product() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

        final int discountedPrice = product.getDiscountedPrice();

        Assertions.assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    void fix_1000_discounted_product() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.FIX_1000_AMOUNT);

        final int discountedPrice = product.getDiscountedPrice();

        Assertions.assertThat(discountedPrice).isEqualTo(0);
    }
}