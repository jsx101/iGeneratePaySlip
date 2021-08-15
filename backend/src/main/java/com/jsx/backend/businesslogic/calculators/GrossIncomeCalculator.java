package com.jsx.backend.businesslogic.calculators;

import org.springframework.stereotype.Service;

@Service
public class GrossIncomeCalculator {
    public GrossIncomeCalculator() {
    }

    public Integer calculate(Integer annualSalary) {
        return (int) Math.round(annualSalary/12.0);
    }
}

