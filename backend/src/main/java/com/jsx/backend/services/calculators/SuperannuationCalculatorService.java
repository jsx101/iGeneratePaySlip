package com.jsx.backend.services.calculators;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
//@ComponentScan
public class SuperannuationCalculatorService {
    @Autowired
    GrossIncomeCalculatorService grossIncomeCalculator;

    public Integer calculate(Integer annualSalary, Double superRate) {
        Integer grossIncome = grossIncomeCalculator.calculate(annualSalary);
        return (int) Math.round(grossIncome*superRate);
    }
}

