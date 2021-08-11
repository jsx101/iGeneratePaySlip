package com.jsx.backend.models.pay_slip_functions;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IncomeTaxCalculator {

    private class IncomeTaxBracket {
        // A class to store data necessary to calculate the income tax amount for a given tax bracket

        private Double incomeLowerLimit;
        private Double incomeUpperLimit;
        private Double baseTax;
        private Double taxPerDollar;
        private Double whenOverThisMuch;

        public IncomeTaxBracket(Double lower, Double upper, Double baseTax, Double taxPD, Double whenOver) {
            this.incomeLowerLimit = lower;
            this.incomeUpperLimit = upper;
            this.baseTax = baseTax;
            this.taxPerDollar = taxPD;
            this.whenOverThisMuch = whenOver;
        }
    }

    // List of tax brackets and other data necessary for calculating income tax
    private List<IncomeTaxBracket> taxBrackets = List.of(
            new IncomeTaxBracket(0.0,18200.0,0.0,0.0,0.0),
            new IncomeTaxBracket(18201.0,37000.0,0.0,0.19,18200.0),
            new IncomeTaxBracket(37001.0,87000.0,3572.0,0.325,37000.0),
            new IncomeTaxBracket(87001.0,180000.0,19822.0,0.37,87000.0),
            new IncomeTaxBracket(180000.0,Double.POSITIVE_INFINITY,54232.0,0.45,180000.0)
    );

    public IncomeTaxCalculator() {
    }

    public Integer calculate(Integer annualSalary) {
        return calculateForTaxIncomeColumn(annualSalary, salaryBelongsInThisTaxBracket(annualSalary));
    }

    private Integer calculateForTaxIncomeColumn(Integer annualSalary, Integer index) {

        // A function to calculate the income tax amount based on the annual salary and which tax bracket it belongs in
        Double amountOver = annualSalary - taxBrackets.get(index).whenOverThisMuch;
        return (int) Math.round((taxBrackets.get(index).baseTax + amountOver*taxBrackets.get(index).taxPerDollar)/12);
    }

    private Integer salaryBelongsInThisTaxBracket(Integer annualSalary) {
        // Determines which tax bracket a given salary belongs in
        if (annualSalary <= taxBrackets.get(0).incomeUpperLimit) {
            return 0;

        } else if (annualSalary <= taxBrackets.get(1).incomeUpperLimit) {
            return 1;

        } else if (annualSalary <= taxBrackets.get(2).incomeUpperLimit) {
            return 2;

        } else if (annualSalary <= taxBrackets.get(3).incomeUpperLimit) {
            return 3;

        } else {
            return 4;
        }
    }
}
