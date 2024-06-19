package com.simple.boottest.pay;

import org.springframework.stereotype.Service;
import com.simple.boottest.pay.payment;

@Service
public class paymentService {
	public boolean processPayment(payment payment) {

        return true;
    }
}
