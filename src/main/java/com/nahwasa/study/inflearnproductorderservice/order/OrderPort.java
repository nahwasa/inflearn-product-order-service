package com.nahwasa.study.inflearnproductorderservice.order;

import com.nahwasa.study.inflearnproductorderservice.product.Product;

interface OrderPort {

    Product getProductById(final Long productId);

    void save(final Order order);
}
