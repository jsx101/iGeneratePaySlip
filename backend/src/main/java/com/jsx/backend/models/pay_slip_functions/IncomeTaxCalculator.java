package com.jsx.backend.models.pay_slip_functions;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IncomeTaxCalculator {

    private List<Double> incomeUpperLimit = List.of(18200.0, 37000.0, 87000.0, 180000.0);
    private List<Double> baseTax = List.of(0.0, 0.0, 3572.0, 19822.0, 54232.0);
    private List<Double> amountPerDollar = List.of(0.0, 0.19, 0.325, 0.37, 0.45);
    private List<Double> incomeLowerLimit = List.of(0.0, 18200.0, 37000.0, 87000.0, 180000.0);

    public IncomeTaxCalculator() {
    }

    public Integer calculate(Integer annualSalary) {
        if (annualSalary <= incomeUpperLimit.get(0)) {
            //System.out.println("Column 0");
            return calculateForTaxIncomeColumn(annualSalary, 0);
        } else if (annualSalary <= incomeUpperLimit.get(1)) {
            //System.out.println("Column 1");
            return calculateForTaxIncomeColumn(annualSalary, 1);
        } else if (annualSalary <= incomeUpperLimit.get(2)) {
            //System.out.println("Column 2");
            return calculateForTaxIncomeColumn(annualSalary, 2);
        } else if (annualSalary <= incomeUpperLimit.get(3)) {
            //System.out.println("Column 3");
            return calculateForTaxIncomeColumn(annualSalary, 3);
        } else {
            //System.out.println("Column 4");
            return calculateForTaxIncomeColumn(annualSalary, 4);
        }
    }

    private Integer calculateForTaxIncomeColumn(Integer annualSalary, Integer index) {

        Double amountOver = annualSalary - incomeLowerLimit.get(index);

        return (int) Math.round((baseTax.get(index) + amountOver*amountPerDollar.get(index))/12);
    }
}
