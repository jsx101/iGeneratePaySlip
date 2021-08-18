package com.jsx.backend.services.calculators;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NetIncomeCalculatorService {

    @Autowired
    GrossIncomeCalculatorService grossIncomeCalculator;
    @Autowired
    IncomeTaxCalculatorService incomeTaxCalculator;

    public Integer calculate(Integer annualSalary) {
        Integer grossIncome = grossIncomeCalculator.calculate(annualSalary);
        Integer incomeTax = incomeTaxCalculator.calculate(annualSalary);
        return grossIncome - incomeTax;
    }
}

