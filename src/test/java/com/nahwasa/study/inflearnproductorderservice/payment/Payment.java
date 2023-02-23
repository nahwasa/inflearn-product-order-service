package com.nahwasa.study.inflearnproductorderservice.payment;

import com.nahwasa.study.inflearnproductorderservice.order.Order;
import org.springframework.util.Assert;

class Payment {

    private Long id;
    private final Order order;
    private final String cardNumber;

    public Payment(final Order order, final String cardNumber) {
        Assert.notNull(order, "주문 필수");
        Assert.notNull(cardNumber, "카드번호 필수");

        this.order = order;
        this.cardNumber = cardNumber;
    }

    public void assignId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
