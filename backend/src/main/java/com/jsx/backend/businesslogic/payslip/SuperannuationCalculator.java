package com.jsx.backend.businesslogic.payslip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@ComponentScan
public class SuperannuationCalculator {
    @Autowired
    GrossIncomeCalculator grossIncomeCalculator;

    public Integer calculate(Integer annualSalary, Double superRate) {
        Integer grossIncome = grossIncomeCalculator.calculate(annualSalary);
        return (int) Math.round(grossIncome*superRate);
    }
}

