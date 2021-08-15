package com.jsx.backend.controllers;

import com.jsx.backend.models.EmployeeDetail;
import com.jsx.backend.models.PaySlip;
import com.jsx.backend.businesslogic.PaySlipGenerator;
import com.jsx.backend.businesslogic.calculators.NetIncomeCalculator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="api/pay-slip")
@AllArgsConstructor
public class PaySlipController {

    @Autowired
    private NetIncomeCalculator netIncomeCalculator;
    @Autowired
    private PaySlipGenerator paySlipGenerator;

    // POST request with employee details
    @PostMapping(path="generate")
    public String generatePaySlip(@RequestBody List<EmployeeDetail> employees) {

        List<PaySlip> paySlips = new ArrayList<>();

        for(int i=0; i< employees.size(); i++){
            paySlips.add(paySlipGenerator.returnPaySlip(employees.get(i)));
        }

        return paySlips.toString();
    }

    // To test a PaySlip instance can successfully call IncomeTaxBracketService and Repository in Controllers package
    // It works
    @GetMapping(path="income-tax/get")
    public Integer getGrossIncome() {
        return netIncomeCalculator.calculate(40000);
    }
}
