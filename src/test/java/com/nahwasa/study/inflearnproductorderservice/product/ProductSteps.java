package com.nahwasa.study.inflearnproductorderservice.product;

import com.nahwasa.study.inflearnproductorderservice.product.application.service.AddProductRequest;
import com.nahwasa.study.inflearnproductorderservice.product.application.service.UpdateProductRequest;
import com.nahwasa.study.inflearnproductorderservice.product.domain.DiscountPolicy;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class ProductSteps {

    public static AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        return request;
    }

    public static ExtractableResponse<Response> 상품등록요청(final AddProductRequest request) {
        return RestAssured.given().log().all() // 요청을 보내는 로그를 남기겠다
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 상품조회요청(final Long productId) {
        return RestAssured.given().log().all()
                .when()
                .get("/products/{productId}", productId)
                .then().log().all()
                .extract();
    }

    public static UpdateProductRequest 상품수정요청_생성() {
        return new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);
    }

    public static ExtractableResponse<Response> 상품수정요청(final Long productId) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(ProductSteps.상품수정요청_생성())
                .when()
                .patch("/products/{productId}", productId)
                .then().log().all()
                .extract();
    }
}