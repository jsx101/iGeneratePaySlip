package com.jsx.backend.models;


//@ComponentScan
public class PaySlip {
    // Employee and pay slip data
    private EmployeeDetail employee;
    private Integer grossIncome;
    private Integer incomeTax;
    private Integer netIncome;
    private Integer superannuation;
    private String paymentStartDate;
    private String paymentEndDate;

    public PaySlip(EmployeeDetail employee,
                   Integer grossIncome,
                   Integer incomeTax,
                   Integer netIncome,
                   Integer superannuation,
                   String startDate,
                   String endDate
    ) {
        this.employee = employee;
        this.grossIncome = grossIncome;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
        this.superannuation = superannuation;
        this.paymentStartDate = startDate;
        this.paymentEndDate = endDate;
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

    // Getters

    public EmployeeDetail getEmployee() {
        return employee;
    }

    public Integer getIncomeTax() {
        return incomeTax;
    }

    public Integer getNetIncome() {
        return netIncome;
    }

    public Integer getSuperannuation() {
        return superannuation;
    }

    public String getPaymentStartDate() {
        return paymentStartDate;
    }

    public String getPaymentEndDate() {
        return paymentEndDate;
    }
}


