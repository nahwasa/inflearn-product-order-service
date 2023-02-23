package com.nahwasa.study.inflearnproductorderservice.payment.application.port;

import com.nahwasa.study.inflearnproductorderservice.order.domain.Order;
import com.nahwasa.study.inflearnproductorderservice.payment.domain.Payment;

public interface PaymentPort {

    Order getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
