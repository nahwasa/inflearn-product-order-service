package com.nahwasa.study.inflearnproductorderservice.product.application.service;

import com.nahwasa.study.inflearnproductorderservice.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

public record UpdateProductRequest(String name, int price, DiscountPolicy discountPolicy) {
    public UpdateProductRequest {
        Assert.hasText(name, "상품명 필수");
        Assert.isTrue(price > 0, "가격은 0보다 커야 합니다.");
        Assert.notNull(discountPolicy, "할인정책 필수");

    }
}
