package com.nahwasa.study.inflearnproductorderservice.order;

import org.springframework.util.Assert;

record CreateOrderRequest(Long productId, int quantity) {

    CreateOrderRequest {
        Assert.notNull(productId, "상품 ID 필수");
        Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
    }
}
