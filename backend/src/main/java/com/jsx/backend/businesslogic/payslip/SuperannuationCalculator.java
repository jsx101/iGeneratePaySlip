package com.jsx.backend.businesslogic.payslip;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
//@ComponentScan
public class SuperannuationCalculator {
    @Autowired
    GrossIncomeCalculator grossIncomeCalculator;

    public Integer calculate(Integer annualSalary, Double superRate) {
        Integer grossIncome = grossIncomeCalculator.calculate(annualSalary);
        return (int) Math.round(grossIncome*superRate);
    }
}

