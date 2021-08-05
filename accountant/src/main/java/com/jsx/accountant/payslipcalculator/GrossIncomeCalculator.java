package com.jsx.accountant.payslipcalculator;

import org.springframework.stereotype.Component;

@Component
public class GrossIncomeCalculator {
    public Integer calculate(Integer annualSalary) {
        return (int) Math.round(annualSalary/12.0);
    }
}

