package com.jsx.backend.controllers;

import com.jsx.backend.models.EmployeeDetail;
import com.jsx.backend.services.PaySlipGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/pay-slip")
@AllArgsConstructor
public class PaySlipController {

    @Autowired
    private PaySlipGeneratorService paySlipGenerator;

    // POST request with employee details
    @PostMapping(path="generate")
    public String generatePaySlip(@RequestBody List<EmployeeDetail> employees) {
        return paySlipGenerator.returnPaySlips(employees).toString();
    }

    /*@GetMapping(path="say-hello")
    public String sayHello(){
        return "Hello!";
    }*/
}
