package com.nahwasa.study.inflearnproductorderservice.product;

import org.springframework.util.Assert;

record GetProductResponse(
        long id,
        String name,
        int price,
        DiscountPolicy discountPolicy
) {
    GetProductResponse {
        Assert.notNull(id, "상품 ID 필수");
        Assert.hasText(name, "상품명 필수");
        Assert.notNull(discountPolicy, "할인정책 필수");
    }
}
