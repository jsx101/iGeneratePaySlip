package com.jsx.backend.businesslogic.calculators;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
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

