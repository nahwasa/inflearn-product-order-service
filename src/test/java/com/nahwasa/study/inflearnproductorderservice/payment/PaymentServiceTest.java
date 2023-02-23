package com.nahwasa.study.inflearnproductorderservice.payment;

import com.nahwasa.study.inflearnproductorderservice.order.OrderService;
import com.nahwasa.study.inflearnproductorderservice.order.OrderSteps;
import com.nahwasa.study.inflearnproductorderservice.product.ProductService;
import com.nahwasa.study.inflearnproductorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentServiceTest {

    @Autowired private ProductService productService;
    @Autowired private OrderService orderService;
    @Autowired private PaymentService paymentService;

    @Test
    void 상품주문() {
        productService.addProduct(ProductSteps.상품등록요청_생성());
        orderService.createOrder(OrderSteps.상품주문요청_생성());
        final PaymentRequest request = PaymentSteps.주문결제요청_생성();

        paymentService.payment(request);

    }

}
