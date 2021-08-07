package com.jsx.backend.controllers;

import com.jsx.backend.models.EmployeeDetail;
import com.jsx.backend.models.PaySlip;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api")
public class Controller {
    @PostMapping(path="generate/pay-slip")
    public String generatePaySlip(@RequestBody EmployeeDetail employee) {
        //System.out.println(employee.toString());
        PaySlip paySlip = new PaySlip(employee);

        paySlip.returnGrossIncomeAmount();
        paySlip.returnIncomeTaxAmount();
        paySlip.returnNetIncome();
        paySlip.returnSuperannuation();
        paySlip.returnPaymentStartDate();
        paySlip.returnPaymentEndDate();

        return paySlip.toString();
    }
}
