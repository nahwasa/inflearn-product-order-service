package com.nahwasa.study.inflearnproductorderservice.product;

import com.nahwasa.study.inflearnproductorderservice.ApiTest;
import com.nahwasa.study.inflearnproductorderservice.product.adapter.ProductRepository;
import com.nahwasa.study.inflearnproductorderservice.product.application.service.ProductService;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class ProductApiTest extends ApiTest {

    @Autowired private ProductService productService;
    @Autowired private ProductRepository productRepository;

    @Test
    void 상품등록() {
        final var request = ProductSteps.상품등록요청_생성();

        final var response = ProductSteps.상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void 상품조회() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        Long productId = 1L;

        final var response = ProductSteps.상품조회요청(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }

    @Test
    void 상품수정() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final Long productId = 1L;

        final ExtractableResponse<Response> response = ProductSteps.상품수정요청(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(productRepository.findById(1L).get().getName()).isEqualTo("상품 수정");
    }

}
