package com.jsx.backend.controllers;

import com.jsx.backend.models.EmployeeDetail;
import com.jsx.backend.models.PaySlip;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="api")
public class PaySlipController {

    // POST request with employee details
    @PostMapping(path="generate/pay-slip")
    public String generatePaySlip(@RequestBody List<EmployeeDetail> employees) {

        List<PaySlip> paySlips = new ArrayList<>();

        for(int i=0; i< employees.size(); i++){
            paySlips.add(new PaySlip(employees.get(i)));

            paySlips.get(i).returnGrossIncomeAmount();
            paySlips.get(i).returnIncomeTaxAmount();
            paySlips.get(i).returnNetIncome();
            paySlips.get(i).returnSuperannuation();
            paySlips.get(i).returnPaymentStartDate();
            paySlips.get(i).returnPaymentEndDate();
        }

        return paySlips.toString();
    }
}
