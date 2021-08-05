package com.jsx.backend.models.pay_slip_functions;

import org.springframework.stereotype.Component;

@Component
public class GrossIncomeCalculator {
    public Integer calculate(Integer annualSalary) {
        return (int) Math.round(annualSalary/12.0);
    }
}

