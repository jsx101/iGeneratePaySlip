package com.jsx.backend.models.payslip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetIncomeCalculator {

    @Autowired
    GrossIncomeCalculator grossIncomeCalculator;
    @Autowired
    IncomeTaxCalculator incomeTaxCalculator;

    public Integer calculate(Integer annualSalary) {
        Integer grossIncome = grossIncomeCalculator.calculate(annualSalary);
        Integer incomeTax = incomeTaxCalculator.calculate(annualSalary);
        return grossIncome - incomeTax;
    }
}

