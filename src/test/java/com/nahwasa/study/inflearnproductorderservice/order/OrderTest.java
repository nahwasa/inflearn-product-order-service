package com.nahwasa.study.inflearnproductorderservice.order;

import com.nahwasa.study.inflearnproductorderservice.order.domain.Order;
import com.nahwasa.study.inflearnproductorderservice.product.domain.DiscountPolicy;
import com.nahwasa.study.inflearnproductorderservice.product.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void getTotalPriceWithNonePolicy() {
        final Order order = new Order(new Product("상품명", 1000, DiscountPolicy.NONE), 2);

        final int totalPrice = order.getTotalPrice();

        Assertions.assertThat(totalPrice).isEqualTo(2000);
    }

    @Test
    void getTotalPriceWithFix1000Policy() {
        final Order order = new Order(new Product("상품명", 2000, DiscountPolicy.FIX_1000_AMOUNT), 2);

        final int totalPrice = order.getTotalPrice();

        Assertions.assertThat(totalPrice).isEqualTo(2000);
    }
}