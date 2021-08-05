package com.jsx.backend.models;

import com.jsx.backend.models.pay_slip_functions.*;
import org.springframework.beans.factory.annotation.Autowired;

public class PaySlip {
    private EmployeeDetail employee;
    private Integer grossIncome;
    private Integer incomeTax;
    private Integer netIncome;
    private Integer superannuation;
    private String paymentStartDate;
    private String paymentEndDate;

    //@Autowired
    private GrossIncomeCalculator grossIncomeCalculator;
    //@Autowired
    private IncomeTaxCalculator incomeTaxCalculator;
    //@Autowired
    private NetIncomeCalculator netIncomeCalculator;
    //@Autowired
    private SuperannuationCalculator superannuationCalculator;
    private PaymentPeriodIdentifier paymentPeriodIdentifier;

    @Autowired
    public PaySlip(EmployeeDetail employee) {
        this.employee = employee;

        this.grossIncomeCalculator = new GrossIncomeCalculator();
        this.incomeTaxCalculator = new IncomeTaxCalculator();
        this.netIncomeCalculator = new NetIncomeCalculator();
        this.superannuationCalculator = new SuperannuationCalculator();
        this.paymentPeriodIdentifier = new PaymentPeriodIdentifier();
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

    public String returnPaymentStartDate() {
        this.paymentStartDate = paymentPeriodIdentifier.getPaymentStartDate(employee.getPaymentMonth());
        return this.paymentStartDate;
    }

    public String returnPaymentEndDate() {
        this.paymentEndDate = paymentPeriodIdentifier.getPaymentEndDate(employee.getPaymentMonth());
        return this.paymentEndDate;
    }

    @Override
    public String toString() {
        return "{" +
                "\"employee\":" + employee +
                ", \"grossIncome\":" + grossIncome +
                ", \"incomeTax\":" + incomeTax +
                ", \"netIncome\":" + netIncome +
                ", \"superannuation\":" + superannuation +
                ", \"paymentStartDate\":\"" + paymentStartDate + '"' +
                ", \"paymentEndDate\":\"" + paymentEndDate + '"' +
                '}';
    }
}


