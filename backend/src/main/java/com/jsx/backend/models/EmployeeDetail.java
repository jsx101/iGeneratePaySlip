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
    //private LocalDate payStartDate;

    public EmployeeDetail() {

    }

    public EmployeeDetail(String firstname, String lastname, Integer annualSalary, Double superRate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.annualSalary = annualSalary;
        this.superRate = superRate;
        //this.payStartDate = payStartDate;
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

    @Override
    public String toString() {
        return "EmployeeDetail{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", annualSalary=" + annualSalary +
                ", superRate=" + superRate +
                '}';
    }

//    public LocalDate getPayStartDate() {
//        return payStartDate;
//    }
//
//    public void setPayStartDate(LocalDate payStartDate) {
//        this.payStartDate = payStartDate;
//    }
}
