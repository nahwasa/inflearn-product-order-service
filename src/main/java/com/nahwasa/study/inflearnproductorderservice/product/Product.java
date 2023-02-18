package com.nahwasa.study.inflearnproductorderservice.product;

import org.springframework.util.Assert;

class Product {
    private final String name;
    private final int price;
    private final DiscountPolicy discountPolicy;
    private Long id;

    public Product(String name, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상품명 필수");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야함");
        Assert.notNull(discountPolicy, "할인정책 필수");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public void assignId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
