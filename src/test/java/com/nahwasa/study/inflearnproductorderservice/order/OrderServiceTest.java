package com.nahwasa.study.inflearnproductorderservice.order;

import com.nahwasa.study.inflearnproductorderservice.product.DiscountPolicy;
import com.nahwasa.study.inflearnproductorderservice.product.Product;
import com.nahwasa.study.inflearnproductorderservice.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

class OrderServiceTest {

    private OrderSerivce orderService;
    private OrderRepository orderRepository;
    private OrderPort orderPort;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepository();
        orderPort = new OrderPort() {

            @Override
            public Product getProductById(final Long productId) {
                return new Product("상품명", 1000, DiscountPolicy.NONE);
            }

            @Override
            public void save(final Order order) {
                orderRepository.save(order);
            }
        };
        orderService = new OrderSerivce(orderPort);
    }

    @Test
    void 상품주문() {
        final Long productId = 1L;
        final int quantity = 2;
        final CreateOrderRequest request = new CreateOrderRequest(productId, quantity);

        orderService.createOrder(request);
    }

    private class OrderSerivce {
        private final OrderPort orderPort;

        private OrderSerivce(final OrderPort orderPort) {
            this.orderPort = orderPort;
        }

        public void createOrder(final CreateOrderRequest request) {
            final Product product = orderPort.getProductById(request.productId());

            final Order order = new Order(product, request.quantity());

            orderPort.save(order);
        }
    }
    private record CreateOrderRequest(Long productId, int quantity) {

        private CreateOrderRequest {
            Assert.notNull(productId, "상품 ID 필수");
            Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
        }
    }

    private class OrderAdapter implements OrderPort {
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

    private class Order {

        private final Product product;
        private final int quantity;
        private Long id;

        public Order(final Product product, final int quantity) {
            Assert.notNull(product, "상품 필수");
            Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
            this.product = product;
            this.quantity = quantity;
        }

        public void assignId(final Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }

    private class OrderRepository {
        private final Map<Long, Order> persistence = new HashMap<>();
        private Long sequence = 0L;

        public void save(final Order order) {
            order.assignId(++sequence);
            persistence.put(order.getId(), order);
        }
    }

    private interface OrderPort {

        Product getProductById(final Long productId);
        void save(final Order order);
    }
}
