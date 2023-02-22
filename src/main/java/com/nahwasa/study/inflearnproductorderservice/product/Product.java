package com.nahwasa.study.inflearnproductorderservice.product;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private DiscountPolicy discountPolicy;

    public Product(String name, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상품명 필수");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야함");
        Assert.notNull(discountPolicy, "할인정책 필수");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }
}
