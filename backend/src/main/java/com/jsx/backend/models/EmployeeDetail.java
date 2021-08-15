package com.jsx.backend.models;

import java.lang.String;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDetail)) return false;
        EmployeeDetail that = (EmployeeDetail) o;
        return Objects.equals(getFirstname(), that.getFirstname()) && Objects.equals(getLastname(), that.getLastname()) && Objects.equals(getAnnualSalary(), that.getAnnualSalary()) && Objects.equals(getSuperRate(), that.getSuperRate()) && Objects.equals(getPaymentMonth(), that.getPaymentMonth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstname(), getLastname(), getAnnualSalary(), getSuperRate(), getPaymentMonth());
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
