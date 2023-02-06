package com.example.demo.resources;

import com.example.demo.PayrollApplication;
import com.example.demo.domain.Payroll;
import com.example.demo.domain.User;
import com.example.demo.feingClients.UserFeign;
import com.example.demo.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/api/payments")
@RequiredArgsConstructor
public class PayrollResource {

    private final PayrollService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long id,
                                              @RequestBody Payroll payment){

       return ResponseEntity.ok().body(service.getPayment(id, payment));


    }
}
