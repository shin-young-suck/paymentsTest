package com.simple.boottest.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


public class paymentController {
	@Autowired
    private paymentService paymentService;

    @GetMapping("/payment")
    public String showPaymentForm() {
        return "payment-form";
    }

    @PostMapping("/process-payment")
    public String processPayment(payment payment, Model model) {
        boolean isSuccess = paymentService.processPayment(payment);
        model.addAttribute("isSuccess", isSuccess);
        model.addAttribute("payment", payment);
        return "payment-result";
    }
}
