package com.nahwasa.study.inflearnproductorderservice.payment;

import java.util.HashMap;
import java.util.Map;

class PaymentRepository {

    private Map<Long, Payment> persistence = new HashMap<>();
    private Long sequence = 0L;

    public void save(final Payment payment) {
        payment.assignId(++sequence);
        persistence.put(payment.getId(), payment);
    }
}
