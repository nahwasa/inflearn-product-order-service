package com.nahwasa.study.inflearnproductorderservice.product;

interface ProductPort {
    void save(final Product product);

    Product getProduct(Long productId);
}
