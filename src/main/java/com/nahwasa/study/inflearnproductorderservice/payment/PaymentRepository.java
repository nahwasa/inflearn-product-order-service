package com.nahwasa.study.inflearnproductorderservice.payment;

import org.springframework.data.jpa.repository.JpaRepository;

interface PaymentRepository extends JpaRepository<Payment, Long> {
}
