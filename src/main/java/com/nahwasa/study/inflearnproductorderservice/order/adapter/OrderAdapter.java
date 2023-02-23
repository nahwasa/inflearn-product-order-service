package com.nahwasa.study.inflearnproductorderservice.order.adapter;

import com.nahwasa.study.inflearnproductorderservice.order.domain.Order;
import com.nahwasa.study.inflearnproductorderservice.order.application.port.OrderPort;
import com.nahwasa.study.inflearnproductorderservice.product.domain.Product;
import com.nahwasa.study.inflearnproductorderservice.product.adapter.ProductRepository;
import org.springframework.stereotype.Component;

@Component
class OrderAdapter implements OrderPort {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    private OrderAdapter(ProductRepository productRepository, final OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public Product getProductById(final Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }

    public void save(final Order order) {
        orderRepository.save(order);
    }
}
