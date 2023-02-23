package com.nahwasa.study.inflearnproductorderservice.order;

import com.nahwasa.study.inflearnproductorderservice.ApiTest;
import com.nahwasa.study.inflearnproductorderservice.product.ProductService;
import com.nahwasa.study.inflearnproductorderservice.product.ProductSteps;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

class OrderApiTest extends ApiTest {

    @Autowired private OrderSerivce orderService;
    @Autowired private ProductService productService;

    @Test
    void 상품주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final var request = OrderSteps.상품주문요청_생성();

        final var response = OrderSteps.상품주문요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }
}
