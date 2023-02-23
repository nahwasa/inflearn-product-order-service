package com.nahwasa.study.inflearnproductorderservice.payment.adapter;

interface PaymentGateway {

    void execute(int totalPrice, String cardNumber);

}
