package com.nahwasa.study.inflearnproductorderservice.payment;

interface PaymentGateway {

    void execute(int totalPrice, String cardNumber);

}
