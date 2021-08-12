package com.jsx.backend.models.payslip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

@Service
@ComponentScan
public class NetIncomeCalculator {

    //@Autowired
    GrossIncomeCalculator grossIncomeCalculator;
    //@Autowired
    IncomeTaxCalculator incomeTaxCalculator;

    @Autowired
    public NetIncomeCalculator(GrossIncomeCalculator grossIncomeCalculator, IncomeTaxCalculator incomeTaxCalculator) {
        this.grossIncomeCalculator = grossIncomeCalculator;
        this.incomeTaxCalculator = incomeTaxCalculator;
    }

    public Integer calculate(Integer annualSalary) {
        Integer grossIncome = grossIncomeCalculator.calculate(annualSalary);
        Integer incomeTax = incomeTaxCalculator.calculate(annualSalary);
        return grossIncome - incomeTax;
    }
}

