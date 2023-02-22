package com.nahwasa.study.inflearnproductorderservice.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductServiceTest {

    private ProductService productService;
    private StubProductPort productPort = new StubProductPort();

    @BeforeEach
    void setUp() {
        productService = new ProductService(productPort);
    }

    @Test
    void 상품수정() {
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
        productPort.getProduct_will_return = product;

        productService.updateProduct(productId, request);

        Assertions.assertThat(product.getName()).isEqualTo("상품 수정");
        Assertions.assertThat(product.getPrice()).isEqualTo(2000);
    }

    private static class StubProductPort implements ProductPort {
        public Product getProduct_will_return;

        @Override
        public void save(final Product product) {

        }

        @Override
        public Product getProduct(final Long productId) {
            return getProduct_will_return;
        }
    }
}
