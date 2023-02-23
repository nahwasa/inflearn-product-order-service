package com.nahwasa.study.inflearnproductorderservice.payment;

import com.nahwasa.study.inflearnproductorderservice.order.Order;
import com.nahwasa.study.inflearnproductorderservice.product.DiscountPolicy;
import com.nahwasa.study.inflearnproductorderservice.product.Product;

class PaymentAdapter implements PaymentPort {

    private final PaymentGateway paymentGateway;
    private final PaymentRepository paymentRepository;

    PaymentAdapter(final PaymentGateway paymentGateway, final PaymentRepository paymentRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Order getOrder(final Long orderId) {
        return new Order(new Product("상품1", 1000, DiscountPolicy.NONE), 2);
    }

    @Override
    public void pay(final int totalPrice, final String cardNumber) {
        paymentGateway.execute(totalPrice, cardNumber);    // 차후 실제 결제 API로 연동 예정
    }

    @Override
    public void save(final Payment payment) {
        paymentRepository.save(payment);
    }
}
