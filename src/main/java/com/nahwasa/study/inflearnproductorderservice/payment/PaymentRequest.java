package com.nahwasa.study.inflearnproductorderservice.payment;

import org.springframework.util.Assert;

record PaymentRequest(Long orderId, String cardNumber) {
    PaymentRequest {
        Assert.notNull(orderId, "주문번호 필수");
        Assert.notNull(cardNumber, "카드번호 필수");
    }
}
