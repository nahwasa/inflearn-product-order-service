package com.nahwasa.study.inflearnproductorderservice.order;

import com.nahwasa.study.inflearnproductorderservice.product.Product;
import org.springframework.util.Assert;

class Order {

    private final Product product;
    private final int quantity;
    private Long id;

    public Order(final Product product, final int quantity) {
        Assert.notNull(product, "상품 필수");
        Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
        this.product = product;
        this.quantity = quantity;
    }

    public void assignId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
