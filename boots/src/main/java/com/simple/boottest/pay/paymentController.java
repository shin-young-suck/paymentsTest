package com.simple.boottest.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/payments")
public class PaymentController {
	
	    @Autowired
	    private IamportService iamportService;

	    @GetMapping("/form")
	    public String paymentForm() {
	        return "paymentForm";
	    }

//	    @PostMapping("/verify")
//	    public String verifyPayment(@RequestParam String impUid, Model model) {
//	        Map<String, Object> paymentInfo = iamportService.getPaymentByImpUid(impUid);
//	        model.addAttribute("paymentInfo", paymentInfo);
//	        return "paymentResult";
//	    }
}
