package ru.gb.openFeign_service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import ru.gb.openFeign_service.model.Payment;

@FeignClient(name = "payment", url = "http://localhost:8080")
public interface PaymentProxy {

    @PostMapping("/payment")
    Payment createPayment(@RequestHeader String requestId, @RequestBody Payment payment);
}
