package com.nahwasa.study.inflearnproductorderservice.order.application.port;

import com.nahwasa.study.inflearnproductorderservice.order.domain.Order;
import com.nahwasa.study.inflearnproductorderservice.product.domain.Product;

public interface OrderPort {

    Product getProductById(final Long productId);

    void save(final Order order);
}
