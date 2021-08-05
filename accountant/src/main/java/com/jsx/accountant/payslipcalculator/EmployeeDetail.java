package com.jsx.accountant.payslipcalculator;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmployeeDetail {
    private String firstname;
    private String lastname;
    private Integer annualSalary;
    private Float superRate;
    private LocalDate payStartDate;

//    public EmployeeDetail(String firstname, String lastname, Integer annualSalary, Float superRate, LocalDate payStartDate) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.annualSalary = annualSalary;
//        this.superRate = superRate;
//        this.payStartDate = payStartDate;
//    }

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

    public Float getSuperRate() {
        return superRate;
    }

    public void setSuperRate(Float superRate) {
        this.superRate = superRate;
    }

    public LocalDate getPayStartDate() {
        return payStartDate;
    }

    public void setPayStartDate(LocalDate payStartDate) {
        this.payStartDate = payStartDate;
    }
}
