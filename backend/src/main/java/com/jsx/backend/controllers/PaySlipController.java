package com.jsx.backend.controllers;

import com.jsx.backend.models.EmployeeDetail;
import com.jsx.backend.models.PaySlip;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="api/pay-slip")
@AllArgsConstructor
public class PaySlipController {

    // POST request with employee details
    @PostMapping(path="generate")
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

    // To test a PaySlip instance can successfully call IncomeTaxBracketService and Repository in Controllers package
    // It works
    @GetMapping(path="income-tax/get")
    public Integer getGrossIncome() {
        PaySlip paySlip = new PaySlip(new EmployeeDetail("david", "rudd", 90050, 0.09, 1));
        return paySlip.returnIncomeTaxAmount();
    }
}
