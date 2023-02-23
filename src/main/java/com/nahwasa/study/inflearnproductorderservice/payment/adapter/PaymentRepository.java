package com.nahwasa.study.inflearnproductorderservice.payment.adapter;

import com.nahwasa.study.inflearnproductorderservice.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

interface PaymentRepository extends JpaRepository<Payment, Long> {
}
