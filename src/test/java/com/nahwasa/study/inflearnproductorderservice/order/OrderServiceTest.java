package com.nahwasa.study.inflearnproductorderservice.order;

import com.nahwasa.study.inflearnproductorderservice.product.ProductService;
import com.nahwasa.study.inflearnproductorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceTest {

    @Autowired private OrderSerivce orderService;
    @Autowired private ProductService productService;

    @Test
    void 상품주문() {
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final CreateOrderRequest request = 상품주문요청_생성();

        orderService.createOrder(request);
    }

    private static CreateOrderRequest 상품주문요청_생성() {
        final Long productId = 1L;
        final int quantity = 2;
        return new CreateOrderRequest(productId, quantity);
    }

}
