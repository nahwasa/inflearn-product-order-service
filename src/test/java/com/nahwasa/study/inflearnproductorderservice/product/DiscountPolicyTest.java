package com.nahwasa.study.inflearnproductorderservice.product;

import com.nahwasa.study.inflearnproductorderservice.product.domain.DiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DiscountPolicyTest {

    @Test
    void none_discounted_price() {
        final int price = 1000;

        final int discountedPrice = DiscountPolicy.NONE.applyDiscount(price);

        Assertions.assertThat(discountedPrice).isEqualTo(price);
    }

    @Test
    void fix_1000_discounted_price() {
        final int price = 2000;

        final int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

        Assertions.assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    void over_discounted_price() {
        final int price = 500;

        final int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

        Assertions.assertThat(discountedPrice).isEqualTo(0);
    }

}