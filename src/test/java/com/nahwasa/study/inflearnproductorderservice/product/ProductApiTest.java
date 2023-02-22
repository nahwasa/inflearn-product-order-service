package com.nahwasa.study.inflearnproductorderservice.product;

import com.nahwasa.study.inflearnproductorderservice.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.awt.*;

import static org.assertj.core.api.Assertions.*;

class ProductApiTest extends ApiTest {

    @Autowired private ProductService productService;

    @Test
    void 상품등록() {
        final var request = 상품등록요청_생성();

        final var response = 상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private static ExtractableResponse<Response> 상품등록요청(final AddProductRequest request) {
        return RestAssured.given().log().all() // 요청을 보내는 로그를 남기겠다
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();
    }

    private static AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        return request;
    }
}
