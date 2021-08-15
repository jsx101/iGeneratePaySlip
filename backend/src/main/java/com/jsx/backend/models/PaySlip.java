package com.jsx.backend.models;


import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaySlip)) return false;
        PaySlip paySlip = (PaySlip) o;
        return Objects.equals(getEmployee(), paySlip.getEmployee()) && Objects.equals(getGrossIncome(), paySlip.getGrossIncome()) && Objects.equals(getIncomeTax(), paySlip.getIncomeTax()) && Objects.equals(getNetIncome(), paySlip.getNetIncome()) && Objects.equals(getSuperannuation(), paySlip.getSuperannuation()) && Objects.equals(getPaymentStartDate(), paySlip.getPaymentStartDate()) && Objects.equals(getPaymentEndDate(), paySlip.getPaymentEndDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployee(), getGrossIncome(), getIncomeTax(), getNetIncome(), getSuperannuation(), getPaymentStartDate(), getPaymentEndDate());
    }

    // Getters

    public EmployeeDetail getEmployee() {
        return employee;
    }

    public Integer getGrossIncome() {
        return grossIncome;
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


