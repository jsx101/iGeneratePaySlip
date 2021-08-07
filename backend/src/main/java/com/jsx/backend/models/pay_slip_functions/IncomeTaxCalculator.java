package com.jsx.backend.models.pay_slip_functions;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IncomeTaxCalculator {

    private class IncomeTaxBracket {
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
        if (annualSalary <= taxBrackets.get(0).incomeUpperLimit) {
            //System.out.println("Column 0");
            return calculateForTaxIncomeColumn(annualSalary, 0);
        } else if (annualSalary <= taxBrackets.get(1).incomeUpperLimit) {
            //System.out.println("Column 1");
            return calculateForTaxIncomeColumn(annualSalary, 1);
        } else if (annualSalary <= taxBrackets.get(2).incomeUpperLimit) {
            //System.out.println("Column 2");
            return calculateForTaxIncomeColumn(annualSalary, 2);
        } else if (annualSalary <= taxBrackets.get(3).incomeUpperLimit) {
            //System.out.println("Column 3");
            return calculateForTaxIncomeColumn(annualSalary, 3);
        } else {
            //System.out.println("Column 4");
            return calculateForTaxIncomeColumn(annualSalary, 4);
        }
    }

    private Integer calculateForTaxIncomeColumn(Integer annualSalary, Integer index) {

        Double amountOver = annualSalary - taxBrackets.get(index).whenOverThisMuch;

        return (int) Math.round((taxBrackets.get(index).baseTax + amountOver*taxBrackets.get(index).taxPerDollar)/12);
    }
}
