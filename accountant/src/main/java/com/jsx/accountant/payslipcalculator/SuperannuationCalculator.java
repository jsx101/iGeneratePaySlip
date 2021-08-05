package com.jsx.accountant.payslipcalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SuperannuationCalculator {
    @Autowired
    GrossIncomeCalculator grossIncomeCalculator;

    public Integer calculate(Integer annualSalary, Double superRate) {
        Integer grossIncome = grossIncomeCalculator.calculate(annualSalary);
        return (int) Math.round(grossIncome*superRate);
    }
}
