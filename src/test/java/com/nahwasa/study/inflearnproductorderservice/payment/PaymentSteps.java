package com.nahwasa.study.inflearnproductorderservice.payment;

public class PaymentSteps {
    static PaymentRequest 주문결제요청_생성() {
        final Long orderId = 1L;
        final String cardNumber = "1234-1234-1234-1234";
        return new PaymentRequest(orderId, cardNumber);
    }
}