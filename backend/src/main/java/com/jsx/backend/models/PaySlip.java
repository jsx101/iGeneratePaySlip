package com.jsx.backend.models;

import com.jsx.backend.models.pay_slip_functions.GrossIncomeCalculator;
import com.jsx.backend.models.pay_slip_functions.IncomeTaxCalculator;
import com.jsx.backend.models.pay_slip_functions.NetIncomeCalculator;
import com.jsx.backend.models.pay_slip_functions.SuperannuationCalculator;
import org.springframework.beans.factory.annotation.Autowired;

public class PaySlip {
    private EmployeeDetail employee;
    private Integer grossIncome;
    private Integer incomeTax;
    private Integer netIncome;
    private Integer superannuation;
    private String fromDate;
    private String toDate;

    //@Autowired
    private GrossIncomeCalculator grossIncomeCalculator;
    //@Autowired
    private IncomeTaxCalculator incomeTaxCalculator;
    //@Autowired
    private NetIncomeCalculator netIncomeCalculator;
    //@Autowired
    private SuperannuationCalculator superannuationCalculator;

    @Autowired
    public PaySlip(EmployeeDetail employee) {
        this.employee = employee;

        this.grossIncomeCalculator = new GrossIncomeCalculator();
        this.incomeTaxCalculator = new IncomeTaxCalculator();
        this.netIncomeCalculator = new NetIncomeCalculator();
        this.superannuationCalculator = new SuperannuationCalculator();
    }

    public Integer returnGrossIncomeAmount() {
        this.grossIncome = grossIncomeCalculator.calculate(employee.getAnnualSalary());
        return this.grossIncome;
    }

    public Integer returnIncomeTaxAmount() {
        this.incomeTax = incomeTaxCalculator.calculate(employee.getAnnualSalary());
        return incomeTax;
    }

    public Integer returnNetIncome() {
        this.netIncome = netIncomeCalculator.calculate(employee.getAnnualSalary());
        return this.netIncome;
    }

    public Integer returnSuperannuation() {
        this.superannuation = superannuationCalculator.calculate(employee.getAnnualSalary(), employee.getSuperRate());
        return this.superannuation;
    }

    @Override
    public String toString() {
        return "PaySlip{" +
                "employee=" + employee +
                ", grossIncome=" + grossIncome +
                ", incomeTax=" + incomeTax +
                ", netIncome=" + netIncome +
                ", superannuation=" + superannuation +
                '}';
    }
}


