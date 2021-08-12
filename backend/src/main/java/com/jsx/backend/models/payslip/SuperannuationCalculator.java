package com.jsx.backend.models.payslip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

@Service
@ComponentScan
public class SuperannuationCalculator {
    //@Autowired
    GrossIncomeCalculator grossIncomeCalculator;

    @Autowired
    public SuperannuationCalculator(GrossIncomeCalculator grossIncomeCalculator) {
        this.grossIncomeCalculator = grossIncomeCalculator;
    }

    public Integer calculate(Integer annualSalary, Double superRate) {
        Integer grossIncome = grossIncomeCalculator.calculate(annualSalary);
        return (int) Math.round(grossIncome*superRate);
    }
}

