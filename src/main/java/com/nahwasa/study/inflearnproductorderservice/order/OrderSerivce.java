package com.nahwasa.study.inflearnproductorderservice.order;

import com.nahwasa.study.inflearnproductorderservice.product.Product;
import org.springframework.stereotype.Component;

@Component
class OrderSerivce {
    private final OrderPort orderPort;

    OrderSerivce(final OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public void createOrder(final CreateOrderRequest request) {
        final Product product = orderPort.getProductById(request.productId());

        final Order order = new Order(product, request.quantity());

        orderPort.save(order);
    }
}
