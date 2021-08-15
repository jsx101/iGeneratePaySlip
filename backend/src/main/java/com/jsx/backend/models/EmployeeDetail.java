package com.jsx.backend.models;

import java.lang.String;


public class EmployeeDetail {
    private String firstname;
    private String lastname;
    private Integer annualSalary;
    private Double superRate;
    private Integer paymentMonth;

    public EmployeeDetail() {
    }

    public EmployeeDetail(String firstname, String lastname, Integer annualSalary, Double superRate, Integer paymentMonth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.annualSalary = annualSalary;
        this.superRate = superRate;
        this.paymentMonth = paymentMonth;
    }

    @Override
    public String toString() {
        return "{" +
                "\"firstname\":\"" + firstname + '"' +
                ", \"lastname\":\"" + lastname + '"' +
                ", \"annualSalary\":" + annualSalary +
                ", \"superRate\":" + superRate +
                ", \"paymentMonth\":" + paymentMonth +
                '}';
    }

    // Getters and setters

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(Integer annualSalary) {
        this.annualSalary = annualSalary;
    }

    public Double getSuperRate() {
        return superRate;
    }

    public void setSuperRate(Double superRate) {
        this.superRate = superRate;
    }

    public Integer getPaymentMonth() {
        return paymentMonth;
    }

    public void setPaymentMonth(Integer paymentMonth) {
        this.paymentMonth = paymentMonth;
    }
}
