package com.jsx.backend.services.calculators;

import org.springframework.stereotype.Service;

@Service
public class GrossIncomeCalculatorService {
    public GrossIncomeCalculatorService() {
    }

    public Integer calculate(Integer annualSalary) {
        return (int) Math.round(annualSalary/12.0);
    }
}

