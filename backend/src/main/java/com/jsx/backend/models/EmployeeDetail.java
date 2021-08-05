package com.jsx.backend.models;

import org.springframework.stereotype.Component;
import java.lang.String;
import java.time.LocalDate;

//@Component
public class EmployeeDetail {
    private String firstname;
    private String lastname;
    private Integer annualSalary;
    private Double superRate;
    private Integer paymentMonth;

    public EmployeeDetail() {

    }

    public EmployeeDetail(String firstname, String lastname, Integer annualSalary, Double superRate, String paymentMonth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.annualSalary = annualSalary;
        this.superRate = superRate/100;
        this.paymentMonth = Integer.parseInt(paymentMonth);
    }

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

    @Override
    public String toString() {
        return "EmployeeDetail{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", annualSalary=" + annualSalary +
                ", superRate=" + superRate +
                '}';
    }
}
