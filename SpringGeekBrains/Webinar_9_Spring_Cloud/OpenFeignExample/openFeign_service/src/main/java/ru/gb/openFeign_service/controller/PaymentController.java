package ru.gb.openFeign_service.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.openFeign_service.model.Payment;
import ru.gb.openFeign_service.proxy.PaymentProxy;

@RestController
@AllArgsConstructor
public class PaymentController {

    private final PaymentProxy proxy;

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment){
        String requestId = "1";

        return proxy.createPayment(requestId, payment);
    }
}
