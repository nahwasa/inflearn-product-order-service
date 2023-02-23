package com.nahwasa.study.inflearnproductorderservice.product.application.port;

import com.nahwasa.study.inflearnproductorderservice.product.domain.Product;

public interface ProductPort {
    void save(final Product product);

    Product getProduct(Long productId);
}
