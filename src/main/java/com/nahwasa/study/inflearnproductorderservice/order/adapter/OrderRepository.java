package com.nahwasa.study.inflearnproductorderservice.order.adapter;

import com.nahwasa.study.inflearnproductorderservice.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
