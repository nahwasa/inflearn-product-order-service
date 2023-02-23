package com.nahwasa.study.inflearnproductorderservice.product.application.service;

import com.nahwasa.study.inflearnproductorderservice.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

public record GetProductResponse(
        long id,
        String name,
        int price,
        DiscountPolicy discountPolicy
) {
    public GetProductResponse {
        Assert.notNull(id, "상품 ID 필수");
        Assert.hasText(name, "상품명 필수");
        Assert.notNull(discountPolicy, "할인정책 필수");
    }
}
