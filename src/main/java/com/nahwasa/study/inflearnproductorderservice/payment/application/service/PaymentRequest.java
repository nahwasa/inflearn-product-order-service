package com.nahwasa.study.inflearnproductorderservice.payment.application.service;

import org.springframework.util.Assert;

public record PaymentRequest(Long orderId, String cardNumber) {
    public PaymentRequest {
        Assert.notNull(orderId, "주문번호 필수");
        Assert.notNull(cardNumber, "카드번호 필수");
    }
}
