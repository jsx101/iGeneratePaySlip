package com.jsx.backend.controllers;

import com.jsx.backend.models.EmployeeDetail;
import com.jsx.backend.models.PaySlip;
import com.jsx.backend.models.payslip.incometaxbracket.IncomeTaxBracket;
import com.jsx.backend.models.payslip.incometaxbracket.IncomeTaxBracketRepository;
import com.jsx.backend.models.payslip.incometaxbracket.IncomeTaxBracketService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(path="api/pay-slip")
@AllArgsConstructor
public class PaySlipController {

    //@Autowired
    private final IncomeTaxBracketService incomeTaxBracketService;
    private final IncomeTaxBracketRepository incomeTaxBracketRepository;

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

    @GetMapping(path="income-tax/get")
    public Integer getGrossIncome() {
        //return incomeTaxBracketRepository.findIncomeTaxBracketByIncomeLowerLimitLessThanEqual(50060);

        PaySlip paySlip = new PaySlip(new EmployeeDetail("david", "rudd", 90050, 0.09, 1));
        return paySlip.returnIncomeTaxAmount();
        //return incomeTaxBracketService.getTaxBracketForSalary(50060);
    }
}
